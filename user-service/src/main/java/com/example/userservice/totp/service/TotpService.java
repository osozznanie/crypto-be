package com.example.userservice.totp.service;


import com.example.userservice.totp.SecretKeyGeneratorTotp;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import de.taimos.totp.TOTP;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.util.encoders.Base32;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Data
public class TotpService {
    private String secretKey;

    public TotpService() {
        this.secretKey = SecretKeyGeneratorTotp.generateSecretKey();
    }

    public String generateTotp() {
        return getTOTPCode(this.secretKey);
    }

    public String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public byte[] generateQRCodeImage(String userName, String secretKey, int width, int height) throws WriterException, IOException {
    String provider = "CryptoWorld-App";
    String otpAuthUrl = String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", provider, userName, secretKey, provider);

    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(otpAuthUrl, BarcodeFormat.QR_CODE, width, height);

    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
    byte[] pngData = pngOutputStream.toByteArray();
    return pngData;
}
}
