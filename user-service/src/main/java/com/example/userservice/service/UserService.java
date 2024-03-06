package com.example.userservice.service;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserRequestDto requestDto);

    UserDto getById(String id);

    List<UserDto> getAll();

    UserDto update(String id, UserRequestDto requestDto);

    void deleteById(String id);

    UserDto findByUsername(String username);

    UserDto findUserByEmail(String email);

    UserDto updatePixelNumber(String email, Long pixelNumber);
}
