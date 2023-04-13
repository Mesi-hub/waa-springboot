package miu.edu.lab6.service;

import miu.edu.lab6.entity.dto.request.LoginRequest;
import miu.edu.lab6.entity.dto.response.LoginResponse;
import miu.edu.lab6.entity.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
