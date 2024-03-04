package com.example.companyservice.feigns;

import com.example.userservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface UserFeign {

    @GetMapping("/api/users/feign-get-user")
    User getUserByEmail(@RequestParam(value = "email") String email);
}
