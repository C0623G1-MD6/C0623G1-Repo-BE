package com.example.fashion.service;

import com.example.fashion.model.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
}
