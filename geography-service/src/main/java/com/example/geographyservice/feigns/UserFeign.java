package com.example.geographyservice.feigns;

import com.example.geographyservice.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
@Component
public interface UserFeign {

    @GetMapping("/api/users/feign-get-user")
    UserDto getUserByEmail(@RequestParam(value = "email") String email);
}
