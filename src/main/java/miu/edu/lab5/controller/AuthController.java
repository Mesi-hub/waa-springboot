package miu.edu.lab5.controller;

import miu.edu.lab5.entity.dto.request.LoginRequest;
import miu.edu.lab5.entity.dto.request.RefreshTokenRequest;
import miu.edu.lab5.entity.dto.response.LoginResponse;
import miu.edu.lab5.service.AuthService;
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

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {



        var loginResponse = authService.login(loginRequest);

        ResponseCookie cookie = ResponseCookie.from("refreshToken", loginResponse.getRefreshToken())
                .httpOnly(true)
                .maxAge(60*60*24)
                .path("/")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString());
return
        ResponseEntity.ok().headers(headers).body(loginResponse);

//        return new ResponseEntity<LoginResponse>(
//                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }



}