package com.example.userservice.service.impl;

import com.example.userservice.totp.service.TotpService;
import com.example.userservice.dto.request.LoginRequestDto;
import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.LoginResponseDTO;
import com.example.userservice.dto.response.RegisterResponseDTO;
import com.example.userservice.enums.ERole;
import com.example.userservice.enums.LoginStatus;
import com.example.userservice.enums.RegisterStatus;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.jwt.JwtTokenUtils;
import com.example.userservice.service.AuthService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtTokenUtils jwtTokenUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper, JwtTokenUtils jwtTokenUtils, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtTokenUtils = jwtTokenUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public LoginResponseDTO createAuthToken(LoginRequestDto loginRequestDto) {
        User loginUser = userRepository.findByEmail(loginRequestDto.getEmail());
        if (loginUser == null) {
            return new LoginResponseDTO(LoginStatus.INVALID_CREDENTIALS, "Invalid email or password", null, null);
        } else if (BCrypt.checkpw(loginRequestDto.getPassword(), loginUser.getPassword())) {
            String userToken = jwtTokenUtils.generateToken(loginUser);

            if (!isTotpValid(loginRequestDto.getTotp(), loginUser.getBc32SecretKeyForGeneratingTotp()) || loginRequestDto.getTotp() == null) {
                return new LoginResponseDTO(LoginStatus.TOTP_REQUIRED, "Invalid TOTP", null, null);
            }

            return new LoginResponseDTO(LoginStatus.SUCCESS, "Login successful", userMapper.toUserDto(loginUser), userToken);
        } else {
            return new LoginResponseDTO(LoginStatus.INVALID_CREDENTIALS, "Invalid password", null, null);
        }
    }

    private boolean isTotpValid(String totp, String bc32SecretKeyForGeneratingTotp) {
        if (bc32SecretKeyForGeneratingTotp == null || bc32SecretKeyForGeneratingTotp.isEmpty()) {
            return false;
        }
        if (totp == null || totp.isEmpty()) {
            return false;
        }
        TotpService totpService = new TotpService();
        String expectedTotp = totpService.getTOTPCode(bc32SecretKeyForGeneratingTotp);
        return totp.equals(expectedTotp);
    }

    @Override
    public RegisterResponseDTO createNewUser(UserRequestDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            return new RegisterResponseDTO(RegisterStatus.EMAIL_TAKEN, "User with this email address is already in the system", null, null, null);
        } else {
            TotpService totpService = new TotpService();
            String b32Code = totpService.getSecretKey();

            try {
                byte[] qrCode = totpService.generateQRCodeImage(userDto.getUsername(), b32Code, 200, 200);

                User newUser = User.builder()
                        .email(userDto.getEmail())
                        .username(userDto.getUsername())
                        .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                        .role(ERole.ROLE_USER)
                        .bc32SecretKeyForGeneratingTotp(b32Code)
                        .build();

                userRepository.save(newUser);

                return new RegisterResponseDTO(RegisterStatus.SUCCESS, "User created successfully", userMapper.toUserDto(newUser), b32Code, qrCode);
            } catch (WriterException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

