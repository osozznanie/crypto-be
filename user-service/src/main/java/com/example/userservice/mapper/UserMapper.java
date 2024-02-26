package com.example.userservice.mapper;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setWalletAddress(user.getWalletAddress());
        dto.setWalletBalance(user.getWalletBalance());
        return dto;
    }

    public void updateModelFromDto(User user, UserRequestDto requestDto) {
        user.setWalletAddress(requestDto.getWalletAddress());
        user.setWalletBalance(requestDto.getWalletBalance());
    }

    public User toModel(UserRequestDto requestDto) {
        User user = new User();
        updateModelFromDto(user, requestDto);
        return user;
    }
}
