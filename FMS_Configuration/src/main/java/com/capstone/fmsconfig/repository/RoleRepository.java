package com.capstone.fmsconfig.repository;

import com.capstone.fmsconfig.entity.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ReactiveCrudRepository<Role, Integer> {
}
