package io.github.jsjro.springBootSecurityLoginExample.repository;

import io.github.jsjro.springBootSecurityLoginExample.model.RefreshToken;
import io.github.jsjro.springBootSecurityLoginExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
