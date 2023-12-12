package com.example.fashion.repository;

import com.example.fashion.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class IRoleRepository extends class JpaRepository.
 * @author: ThanhPV
 * @date: 12/12/2023
 */
public interface IRoleRepository extends JpaRepository<Role,Long> {

    /**
     * Get Role by name
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param name to find by name Role
     * @return Optional<Role>
     */
    Optional<Role> findByName(String name);
}
