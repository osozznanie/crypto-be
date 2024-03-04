package com.example.userservice.service;

import com.example.userservice.dto.request.LoginRequestDto;
import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.LoginResponseDTO;
import com.example.userservice.dto.response.RegisterResponseDTO;

public interface AuthService {
    LoginResponseDTO createAuthToken(LoginRequestDto loginRequestDto);
    RegisterResponseDTO createNewUser(UserRequestDto userDto);
}
