package com.example.fashion.repository.auth;

import com.example.fashion.model.auth.Account;
import com.example.fashion.model.auth.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPasswordResetTokenRepo extends JpaRepository<PasswordResetToken,Long> {
    Boolean existsByToken(String token);
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByAccount(Account account);
}
