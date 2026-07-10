package com.devconnect.user.service;

import com.devconnect.user.dto.UserStatusResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final Map<String, String> users = Map.of(
            "u001", "ACTIVE",
            "u002", "ACTIVE",
            "u003", "INACTIVE"
    );

    public Optional<UserStatusResponse> getUserStatus(String userId) {
        String status = users.get(userId);

        if (status == null) {
            return Optional.empty();
        }

        return Optional.of(new UserStatusResponse(userId, status));
    }
}
