package com.example.userservice.totp;

import org.bouncycastle.util.encoders.Base32;

import java.security.SecureRandom;

public class SecretKeyGeneratorTotp {

    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        byte[] encodedBytes = base32.encode(bytes);
        return new String(encodedBytes);
    }
}
