package com.example.fashion.repository;

import com.example.fashion.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
}
