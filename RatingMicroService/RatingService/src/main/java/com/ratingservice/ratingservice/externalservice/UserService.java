package com.ratingservice.ratingservice.externalservice;

import com.ratingservice.ratingservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE",path = "/api/user")
public interface UserService {
    @GetMapping("/getuser/{userId}")
    User getUserById(@PathVariable String userId);
}
