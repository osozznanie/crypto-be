package com.example.userservice.service.impl;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserRequestDto requestDto) {
        User user = userMapper.toModel(requestDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getById(String id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user is found with id = " + id)
        ));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto update(String id, UserRequestDto requestDto) {
        User userForUpdate = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user is found with id = " + id)
        );
        userMapper.updateModelFromDto(userForUpdate, requestDto);
        userRepository.save(userForUpdate);
        return userMapper.toDto(userForUpdate);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
