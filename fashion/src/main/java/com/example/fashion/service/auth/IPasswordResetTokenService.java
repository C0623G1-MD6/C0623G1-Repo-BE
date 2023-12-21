package com.example.fashion.service.auth;

import com.example.fashion.model.auth.Account;
import com.example.fashion.model.auth.PasswordResetToken;

public interface IPasswordResetTokenService {
    void createPasswordResetTokenForUser(PasswordResetToken passwordResetToken);
    Boolean existsByToken(String token);
    PasswordResetToken getPasswordResetToken(String token);
    PasswordResetToken getPasswordResetToken(Account account);
}
