package com.example.secretsanta.domain;

import jakarta.persistence.*; //imports JPA annotations to define database mapping... @Id, etc.
import java.util.Set; 
//Set is a collection that holds unique items
//each user can belong to multiple groups
//each group can have multiple users
//we need a collection type that can represent "all the groups this user is in"
//Set is good here because a user shouldn't be in the same group twice


@Entity //marks this class as a JPA (Java Persistence API) entity -> mapping to a DB table
@Table(name = "users") //specifies table name in the DB
public class User {

    @Id //marks the id field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tells the database to auto-generate ID's

    private Long id; //unique ID for each user

    private String name; //user's display name

    private String email; //user's email

    private String password; //user's password

    @ManyToMany(mappedBy = "members") 
    //represents relationships to groups
    //many users can be in many groups and vice versa
    //mappedBy points to the members field in the Group entity 
    //using Set<Group> avoids duplicate memberships

    private Set<Group> groups; //holds all groups that this user is part of 
    
    //getters and setters (or use Lombok)
}
