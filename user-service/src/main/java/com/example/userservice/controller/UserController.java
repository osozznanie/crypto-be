package com.example.userservice.controller;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto addPixelTransaction(@RequestBody @Valid UserRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @GetMapping("/{id}")
    public UserDto getPixelTransactionById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getPixelTransactions() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserDto updatePixelTransaction(@PathVariable String id,
                                                      @RequestBody @Valid UserRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deletePixelTransaction(@PathVariable String id) {
        userService.deleteById(id);
        return "User with id = " + id + " is successfully removed";
    }
}
