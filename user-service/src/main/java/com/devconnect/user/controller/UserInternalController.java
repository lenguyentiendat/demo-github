package com.devconnect.user.controller;

import com.devconnect.user.dto.ApiResponse;
import com.devconnect.user.dto.UserStatusResponse;
import com.devconnect.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
public class UserInternalController {

    private final UserService userService;

    public UserInternalController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/status")
    public ResponseEntity<ApiResponse<UserStatusResponse>> getUserStatus(@PathVariable String userId) {
        return userService.getUserStatus(userId)
                .map(response -> ResponseEntity.ok(
                        ApiResponse.success("User status found", response)
                ))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("User not found")));
    }
}
