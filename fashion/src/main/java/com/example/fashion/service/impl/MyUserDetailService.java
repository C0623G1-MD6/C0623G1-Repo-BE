package com.example.fashion.service.impl;

import com.example.fashion.model.auth.Account;
import com.example.fashion.model.auth.MyUserDetail;
import com.example.fashion.repository.auth.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class implements the UserDetailsService interface for loading user details.
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * This method loads user details by username.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param username The username.
     * @return The user details of the specified username.
     * @throws UsernameNotFoundException If the username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " không tồn tại"));
        return new MyUserDetail(account);
    }
}
