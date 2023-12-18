package com.example.fashion.service.impl;

import com.example.fashion.model.auth.Role;
import com.example.fashion.repository.auth.IRoleRepository;
import com.example.fashion.service.auth.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    /**
     * This method finds a role by name.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param name The name of the role.
     * @return An optional containing the role if found, or an empty optional if not found.
     */
    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findRole() {
        return roleRepository.findAll();
    }
}
