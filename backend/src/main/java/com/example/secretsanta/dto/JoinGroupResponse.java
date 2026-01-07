package com.example.secretsanta.dto;

public class JoinGroupResponse {
    
    private String message;
    private Long groupId;
    private String groupName;
    private String inviteCode;

    //constructor
    public JoinGroupResponse(String message, Long groupId, String groupName, String inviteCode) {
        this.message = message;
        this.groupId = groupId;
        this.groupName = groupName;
        this.inviteCode = inviteCode;
    }

    //getters

    public String getMessage() {
        return message;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    //setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
