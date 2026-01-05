package com.example.secretsanta.service;

import com.example.secretsanta.domain.Group;
import com.example.secretsanta.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service

public class GroupService {
    
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(String name, int budget) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be empty.");
        }

        if (budget <= 0) {
            throw new IllegalArgumentException("Budget must be greater than 0.");
        }

        Group group = new Group();
        group.setName(name);
        group.setBudget(budget);
        return groupRepository.save(group);
        
    }
}