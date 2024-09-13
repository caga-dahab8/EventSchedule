package com.eventschadule.eventschadule.services;


import com.eventschadule.eventschadule.dto.EventDTO;
import com.eventschadule.eventschadule.exception.ResourceNotFoundException;
import com.eventschadule.eventschadule.model.Event;
import com.eventschadule.eventschadule.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EventDTO getEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return convertToDTO(event);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = convertToEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
        return convertToDTO(savedEvent);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setDateTime(eventDTO.getDateTime());
        Event updatedEvent = eventRepository.save(event);
        return convertToDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setDateTime(event.getDateTime());
        return dto;
    }


    private Event convertToEntity(EventDTO dto) {
        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setDateTime(dto.getDateTime());
        return event;
    }
}
