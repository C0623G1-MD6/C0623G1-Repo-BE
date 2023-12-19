package com.example.fashion.service.auth;

import com.example.fashion.model.auth.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    /**
     * Finds a role by name.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param name The name of the role.
     * @return An optional containing the role if found, or an empty optional if not found.
     */
    Optional<Role> findByName(String name);
    List<Role> findRole();
}
