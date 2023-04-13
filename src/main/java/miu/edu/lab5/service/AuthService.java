package miu.edu.lab5.service;

import miu.edu.lab5.entity.dto.request.LoginRequest;
import miu.edu.lab5.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
   // LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
