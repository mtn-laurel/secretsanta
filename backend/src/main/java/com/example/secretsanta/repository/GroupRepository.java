package com.example.secretsanta.repository;

import com.example.secretsanta.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
