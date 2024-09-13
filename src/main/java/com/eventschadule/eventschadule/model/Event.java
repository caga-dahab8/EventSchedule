package com.eventschadule.eventschadule.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Data //Getter and Setter
@Table(name = "events")


public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime dateTime;

}

