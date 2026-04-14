package com.ironhack.jpa_relationships.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false,length = 50)
    private LocalDate date;
    @Column(nullable = false,length = 50)
    private Integer duration;
    @Column(nullable = false,length = 50)
    private String location;

    @ManyToMany
    @JoinTable(name="event_guest",
    joinColumns = @JoinColumn(name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests=new ArrayList<>();

}
