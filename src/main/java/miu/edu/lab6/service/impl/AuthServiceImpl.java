package miu.edu.lab6.service.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.lab6.entity.dto.request.LoginRequest;
import miu.edu.lab6.entity.dto.request.RefreshTokenRequest;
import miu.edu.lab6.entity.dto.response.LoginResponse;
import miu.edu.lab6.service.AuthService;
import miu.edu.lab6.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    private final HttpServletRequest httpServletRequest;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
            //  issue Date, then accept the renewal)
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            // TODO (OPTIONAL) When to renew the refresh token?
            return loginResponse;
        }
        return new LoginResponse();
    }

    @Override
    public LoginResponse checkRefreshToken() throws ServletException {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            httpServletRequest.logout();
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refreshToken")) {
                String refreshToken = cookie.getValue();
                boolean isRefreshTokenValid = jwtUtil.validateToken(refreshToken);

                if (isRefreshTokenValid) {
                    var accessToken = jwtUtil.generateRefreshToken(jwtUtil.getSubject(refreshToken));
                    System.out.println("***************************************");
                    System.out.println("TOKEN REFRESHED as =>" + refreshToken);
                    System.out.println("***************************************");

                    SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(accessToken));
                  return new LoginResponse(accessToken,refreshToken);
                } else {
                    System.out.println("***************************************");
                    System.out.println("REFRESH TOKEN IS INVALID.");
                    System.out.println("***************************************");
                    httpServletRequest.logout();
                }
            } else {
                httpServletRequest.logout();
            }
        }
        return new LoginResponse();
 }
}