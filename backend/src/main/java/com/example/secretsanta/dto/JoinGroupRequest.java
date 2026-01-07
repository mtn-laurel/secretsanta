package com.example.secretsanta.dto;

import java.util.List;
import jakarta.validation.constraints.*;

public class JoinGroupRequest {
    
    @NotBlank
    private String inviteCode;

    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String email;

    @Size(min = 4, max = 10)
    List<String> wishListItems;

    //getters

    public String getInviteCode() {
        return inviteCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getWishListItems() {
        return wishListItems;
    }

    //setters

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWishListItems(List<String> wishListItems) {
        this.wishListItems = wishListItems;
    }
}