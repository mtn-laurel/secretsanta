package com.example.secretsanta.service;

import com.example.secretsanta.domain.Group;
import com.example.secretsanta.domain.User;
import org.springframework.stereotype.Service;
import com.example.secretsanta.repository.GroupRepository;
import com.example.secretsanta.repository.UserRepository;

@Service

public class GroupService {
    
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
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
        group.generateInviteCode();
        return groupRepository.save(group);
        
    }

    //add user to a group
    //given a group id and member id,
    //i need to make sure the group exists, 
    //the user exists, and that the user isnt already in the group
    //then add and save the user to the group
    //inputs: user_id, group_id
    //outputs: updated Group now including new added user id
    
    public Group addUsertoGroup(Long userId, Long groupId) {
        //access data from repositories
        Group group = groupRepository.findById(groupId)
                .orElseThrow(()-> new IllegalArgumentException("Group not found."));
       
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("User not found."));

        //operation should not be allowed if user is already in group
        if (group.getMembers().contains(user)) {
            throw new IllegalStateException("User already in group");
        }
        
        group.getMembers().add(user);

        return groupRepository.save(group);
    }

}