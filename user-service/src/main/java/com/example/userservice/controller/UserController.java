package com.example.userservice.controller;

import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.request.UserUpdateRequestDto;
import com.example.userservice.dto.response.UserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public String get() {
        return "Hello World";
    }

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

    @GetMapping("/feign-get-user")
    public UserDto getUserByEmail(@RequestParam(value = "email") String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("/feign-update-pixel-number")
    public UserDto updateUserPixelNumber(@RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        return userService.updatePixelNumber(userUpdateRequestDto.getEmail(), userUpdateRequestDto.getPixelNumber());
    }
}
