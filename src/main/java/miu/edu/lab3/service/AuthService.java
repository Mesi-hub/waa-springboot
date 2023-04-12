package miu.edu.lab3.service;

import miu.edu.lab3.dto.request.LoginRequest;
import miu.edu.lab3.dto.response.LoginResponse;
import miu.edu.lab3.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
