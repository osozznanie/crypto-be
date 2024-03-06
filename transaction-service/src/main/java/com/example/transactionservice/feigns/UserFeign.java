package com.example.transactionservice.feigns;

import com.example.transactionservice.dto.request.UserUpdateRequestDto;
import com.example.transactionservice.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface UserFeign {

    @GetMapping("/api/users/feign-get-user")
    UserDto getUserByEmail(@RequestParam(value = "email") String email);

    @PutMapping("/api/users/feign-update-pixel-number")
    void updateUserPixelNumber(@RequestBody UserUpdateRequestDto userUpdateRequestDto);
}
