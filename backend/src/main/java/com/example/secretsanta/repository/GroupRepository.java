package com.example.secretsanta.repository;

import java.util.Optional;
import com.example.secretsanta.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
    Optional<Group> findByInviteCode(String inviteCode);
    
}
