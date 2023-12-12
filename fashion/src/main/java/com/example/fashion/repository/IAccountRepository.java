package com.example.fashion.repository;

import com.example.fashion.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class IAccountRepository extends class JpaRepository.
 * @author: ThanhPV
 * @date: 12/12/2023
 */
public interface IAccountRepository extends JpaRepository<Account,Long> {

    /**
     * Get Information Account by Username
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username to find username
     * @return Optional<Account>
     */
    Optional<Account> findByUsername(String username);

    /**
     * Check exist Account by Username
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username to find username
     * @return Boolean
     */
    Boolean existsByUsername(String username);
}
