package com.example.userservice.service.impl;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.enums.ERole;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto save(UserRequestDto requestDto) {
        User user = userMapper.toModel(requestDto);
        user.setRole(ERole.ROLE_USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto getById(String id) {
        return userMapper.toUserDto(userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user is found with id = " + id)
        ));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public UserDto update(String id, UserRequestDto requestDto) {
        User userForUpdate = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user is found with id = " + id)
        );
        userMapper.updateModelFromDto(userForUpdate, requestDto);
        userRepository.save(userForUpdate);
        return userMapper.toUserDto(userForUpdate);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toUserDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return userMapper.toUserDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto updatePixelNumber(String email, Long pixelNumber) {
        User user = userRepository.findByEmail(email);
        user.setPixelNumber(pixelNumber);
        return userMapper.toUserDto(userRepository.save(user));
    }
}
