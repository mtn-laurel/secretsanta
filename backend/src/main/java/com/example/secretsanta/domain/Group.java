package com.example.secretsanta.domain;

import jakarta.persistence.*;
import java.util.Set;
import java.util.Random;

@Entity
@Table(name = "secret_groups")
public class Group {

    private static final String ALLOWED_CHARS = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
    private static final Random RANDOM = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //group id

    private String inviteCode; //invite code
    private String name; // group name
    private int budget; // group budget
    
    @ManyToMany
    @JoinTable(
        name = "group_members",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members; // group members

    private boolean drawn = false; // has the drawn happened? 

    public Group() {}

    public void generateInviteCode() {
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) 
            {
            int index = RANDOM.nextInt(ALLOWED_CHARS.length());
            sb.append(ALLOWED_CHARS.charAt(index));
        }
        
        this.inviteCode = sb.toString();
    }

    //getters
    public Long getId() {
        return id;
    }
    
    public String getInviteCode() {
        return inviteCode;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public Set<User> getMembers() {
        return members;
    }

    public boolean isDrawn() {
        return drawn;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }
}
