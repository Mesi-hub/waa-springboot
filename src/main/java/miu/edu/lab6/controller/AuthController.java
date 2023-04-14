package miu.edu.lab6.controller;

import miu.edu.lab6.entity.dto.request.LoginRequest;
import miu.edu.lab6.entity.dto.request.RefreshTokenRequest;
import miu.edu.lab6.entity.dto.response.LoginResponse;
import miu.edu.lab6.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // receive a LoginRequest object in the request body and return a LoginResponse object in the response body.
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);

        // set a refreshToken cookie in the response headers
        ResponseCookie cookie = ResponseCookie.from("refreshToken", loginResponse.getRefreshToken())
                .httpOnly(true)
                .maxAge(60*60*24)
                .path("/")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString());
return
        ResponseEntity.ok().headers(headers).body(loginResponse);
    }

    //receive a RefreshTokenRequest object in the request body and return a LoginResponse object in the response body.
    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }



}