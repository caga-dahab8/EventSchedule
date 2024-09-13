package com.eventschadule.eventschadule.controller;


import com.eventschadule.eventschadule.dto.EventDTO;
import com.eventschadule.eventschadule.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")

public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("event", new EventDTO());
        return "add-event";
    }

    @PostMapping("/add")
    public String addEvent(@ModelAttribute EventDTO eventDTO) {
        eventService.createEvent(eventDTO);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEvent(id));
        return "edit-event";
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute EventDTO eventDTO) {
        eventService.updateEvent(id, eventDTO);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
