package com.piotrblachnio.reddit.services;

import com.piotrblachnio.reddit.exceptions.InvalidRefreshTokenException;
import com.piotrblachnio.reddit.models.RefreshToken;
import com.piotrblachnio.reddit.repositories.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        var refreshToken = new RefreshToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token).orElseThrow(() -> new InvalidRefreshTokenException());
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}