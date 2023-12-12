package com.example.fashion.service.impl;

import com.example.fashion.model.Account;
import com.example.fashion.repository.IAccountRepository;
import com.example.fashion.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * This method finds an account by username.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username The username.
     * @return An optional containing the account if found, or an empty optional if not found.
     */
    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    /**
     * This method checks if an account exists by username.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username The username.
     * @return true if the account exists, false otherwise.
     */
    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    /**
     * This method saves an account.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param account The account to be saved.
     */
    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

}
