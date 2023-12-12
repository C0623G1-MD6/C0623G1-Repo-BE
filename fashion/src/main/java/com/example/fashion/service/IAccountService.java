package com.example.fashion.service;

import com.example.fashion.model.Account;

import java.util.Optional;

public interface IAccountService {
    /**
     * Finds an account by username.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username The username.
     * @return An optional containing the account if found, or an empty optional if not found.
     */
    Optional<Account> findByUsername(String username);

    /**
     * Checks if an account exists by username.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username The username.
     * @return true if the account exists, false otherwise.
     */
    Boolean existsByUsername(String username);

    /**
     * Saves an account.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param account The account to be saved.
     */
    void saveAccount(Account account);
}
