package com.capstone.fmsconfig.service;

import com.capstone.fmsconfig.entity.Role;
import com.capstone.fmsconfig.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Mono<Role> createRole(Role role) {
        return roleRepository.save(role);
    }

    public Flux<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Mono<Void> deleteRoleById(Integer roleId) {
        return roleRepository.deleteById(roleId);
    }
}
