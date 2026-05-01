package com.vector.user.service;

import com.vector.user.dto.RegisterRequest;
import com.vector.user.entity.User;

public interface AuthService {

    void register(RegisterRequest request);

    User login(String email, String rawPassword);
}