package com.example.fashion.service.impl;

import com.example.fashion.model.auth.Account;
import com.example.fashion.model.auth.PasswordResetToken;
import com.example.fashion.repository.auth.IPasswordResetTokenRepo;
import com.example.fashion.service.auth.IPasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService implements IPasswordResetTokenService {
    @Autowired
    private IPasswordResetTokenRepo passwordResetTokenRepo;

    @Override
    public void createPasswordResetTokenForUser(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepo.save(passwordResetToken);
    }

    @Override
    public Boolean existsByToken(String token) {
        return passwordResetTokenRepo.existsByToken(token);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return passwordResetTokenRepo.findByToken(token);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(Account account) {
        return passwordResetTokenRepo.findByAccount(account);
    }
}
