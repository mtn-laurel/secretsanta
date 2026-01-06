package com.example.secretsanta.controller;

//import the Group entity (domain model)
import com.example.secretsanta.domain.Group; 

//import the service that contains business logic
import com.example.secretsanta.service.GroupService;

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
    public Group createGroup(@RequestBody Group group) {
        
        //delegate the actual creation logic to the service layer
        //the controller extracts only the needed fields
        return groupService.createGroup(
            group.getName(), 
            group.getBudget()
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
        return groupService.addUsertoGroup(userId, groupId);
    }
}
