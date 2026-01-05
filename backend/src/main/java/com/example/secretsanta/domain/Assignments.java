package com.example.secretsanta.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "assignments")

public class Assignments {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne 
    @JoinColumn(name = "giver_id", nullable = false)
    private User giver;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User reciever;

    //Getters and setters
}
