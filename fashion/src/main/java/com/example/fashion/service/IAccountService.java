package com.example.fashion.service;

import com.example.fashion.model.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
}
