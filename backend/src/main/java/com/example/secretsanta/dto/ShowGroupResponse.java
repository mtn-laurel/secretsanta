package com.example.secretsanta.dto;

import java.util.List;

public class ShowGroupResponse {
    
    private Long groupId;
    private String groupName;
    private List<String> members;

    public ShowGroupResponse(Long groupId, String groupName, List<String> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = members;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<String> getMembers() {
        return members;
    }
}
