package com.example.userservice.mapper;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserRequestDto toUserRequestDto(User user) {
        UserRequestDto dto = new UserRequestDto();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public void updateModelFromDto(User user, UserRequestDto requestDto) {
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        user.setEmail(requestDto.getEmail());
    }

    public User toModel(UserRequestDto requestDto) {
        User user = new User();
        updateModelFromDto(user, requestDto);
        return user;
    }

    public User toModel(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getEmail());
        return user;
    }
}
