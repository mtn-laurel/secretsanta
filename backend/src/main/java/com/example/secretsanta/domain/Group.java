package com.example.secretsanta.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int budget;

    public Group() {
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
        name = "group_members",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members;

    private boolean drawn = false;

    //Getters and setters
    
}
