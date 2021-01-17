package com.piotrblachnio.reddit.controller;

import com.piotrblachnio.reddit.constants.ApiRoutes;
import com.piotrblachnio.reddit.dto.request.*;
import com.piotrblachnio.reddit.dto.response.AuthenticationResponse;
import com.piotrblachnio.reddit.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService _authService;
    private final RefreshTokenService _refreshTokenService;

    @PostMapping(ApiRoutes.Auth.REGISTER)
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest registerRequest) {
        _authService.register(registerRequest);
    }

    @PostMapping(ApiRoutes.Auth.LOGIN)
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return _authService.login(loginRequest);
    }

    @PostMapping(ApiRoutes.Auth.LOGOUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        _refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
    }

    @PostMapping(ApiRoutes.Auth.REFRESH_TOKEN)
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return _authService.refreshToken(refreshTokenRequest);
    }

    @GetMapping(ApiRoutes.Auth.CONFIRM_EMAIL)
    @ResponseStatus(HttpStatus.OK)
    public void confirmEmail(@PathVariable String token) {
        _authService.verifyAccount(token);
    }
}