package com.example.secretsanta.repository;

import com.example.secretsanta.domain.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignments, Long> {
    
    @Query(
        value = """
            SELECT *
            FROM assignments
            WHERE group_id = ?1
        """,
        nativeQuery = true
    )
    List<Assignments> findByGroupIdNative(Long groupId);
}
