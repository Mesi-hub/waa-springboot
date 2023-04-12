package miu.edu.lab5.service;

import miu.edu.lab5.dto.request.LoginRequest;
import miu.edu.lab5.dto.response.LoginResponse;
import miu.edu.lab5.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
