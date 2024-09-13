package com.eventschadule.eventschadule.repository;


import com.eventschadule.eventschadule.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
