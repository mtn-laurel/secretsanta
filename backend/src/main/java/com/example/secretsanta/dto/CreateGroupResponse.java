package com.example.secretsanta.dto;

public class CreateGroupResponse {

    private String message;
    private String inviteCode;
    private Long groupId;

    public CreateGroupResponse(String message, String inviteCode, Long groupId) {
        this.message = message;
        this.inviteCode = inviteCode;
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public Long getGroupId() {
        return groupId;
    }
}