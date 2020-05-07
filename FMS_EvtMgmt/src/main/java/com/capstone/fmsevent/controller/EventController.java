package com.capstone.fmsevent.controller;

import com.capstone.fmsevent.dto.DashboardResponseDTO;
import com.capstone.fmsevent.entity.Event;
import com.capstone.fmsevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public Flux<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/dashboard")
    public Mono<DashboardResponseDTO> getDashboardInfo() {
        return eventService.getDashboardInfo();
    }
}
