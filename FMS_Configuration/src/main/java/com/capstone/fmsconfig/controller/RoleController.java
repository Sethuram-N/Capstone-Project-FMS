package com.capstone.fmsconfig.controller;

import com.capstone.fmsconfig.entity.Role;
import com.capstone.fmsconfig.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<Mono<Role>> createRole(@RequestBody Role role) {
                Mono<Role> roleMono = roleService.createRole(role);
                return new ResponseEntity<>(roleMono, HttpStatus.CREATED);

    }

    @GetMapping("/role")
    public Flux<Role> getRoles() {
        return roleService.getRoles();
    }

    @DeleteMapping("/role/{roleId}")
    public Mono<Void> deleteRoleById(@PathVariable Integer roleId) {
        return roleService.deleteRoleById(roleId);
    }

}
