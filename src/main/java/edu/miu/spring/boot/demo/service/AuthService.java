package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.entity.dto.request.LoginRequest;
import edu.miu.spring.boot.demo.entity.dto.request.RefreshTokenRequest;
import edu.miu.spring.boot.demo.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
