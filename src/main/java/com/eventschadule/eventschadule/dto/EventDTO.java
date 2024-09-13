package com.eventschadule.eventschadule.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;

    // Getters and setters
    // Constructor
    // toString method
}
