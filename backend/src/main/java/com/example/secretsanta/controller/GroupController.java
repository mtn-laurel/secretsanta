package com.example.secretsanta.controller;

import com.example.secretsanta.domain.Group;

//import the service that contains business logic
import com.example.secretsanta.service.GroupService;

//import dto for create group request
import com.example.secretsanta.dto.CreateGroupRequest;

//import dto for create group response
import com.example.secretsanta.dto.CreateGroupResponse;

// Soring Web annotations
import org.springframework.web.bind.annotation.*;

//marks this class as a REST API controller
//auto converts return values to JSON
//tells Spring this class gandles HTTP requests
@RestController 

//defines the base URL for all endpoints in this controller.
//every method below will start will class /api/groups
@RequestMapping("/api/groups")

//the controller depends on the GroupService
//it does not talk directly to repositories or the database

public class GroupController {

    private final GroupService groupService;

    //constructor injection
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    //create a new group
    //RequestBody tells spring to read JSON from request body
    //and convert it into a Group object
    @PostMapping
    public CreateGroupResponse createGroup(@RequestBody CreateGroupRequest request) {
        Group group = groupService.createGroup(request.getName(), request.getBudget());
        return new CreateGroupResponse(
            "Group created successfully",
            group.getInviteCode(),
            group.getId()
        );
    }

    //add user to a group
    @PostMapping("/{groupId}/users/{userId}")
    public Group addUserToGroup(

            //extracts {groupId} from URL
            @PathVariable Long groupId, 
            //extracts {userId} from URL
            @PathVariable Long userId
    ) {
        return groupService.addUserToGroup(userId, groupId);
    }
}
