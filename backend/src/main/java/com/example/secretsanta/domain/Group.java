package com.example.secretsanta.domain;

import jakarta.persistence.*;
import java.util.Set;
import java.util.Random;

@Entity
@Table(name = "groups")
public class Group {

    private static final String ALLOWED_CHARS = "ABCDEFGHJKMNPQRSTUVWXYZ23456789";
    private static final Random RANDOM = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inviteCode;
    private String name;
    private int budget;
    
    @ManyToMany
    @JoinTable(
        name = "group_members",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members;

    private boolean drawn = false;

    public Group() {}

    public void generateInviteCode() {
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int index = RANDOM.nextInt(ALLOWED_CHARS.length());
            sb.append(ALLOWED_CHARS.charAt(index));
        }
        
        this.inviteCode = sb.toString();
    }

    //getters/setters
    
    public String getInviteCode() {
        return inviteCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Set<User> getMembers() {
        return members;
    }
    
}
