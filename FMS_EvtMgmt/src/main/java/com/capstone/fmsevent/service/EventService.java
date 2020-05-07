package com.capstone.fmsevent.service;

import com.capstone.fmsevent.dto.DashboardResponseDTO;
import com.capstone.fmsevent.entity.Event;
import com.capstone.fmsevent.repository.EmployeeRepository;
import com.capstone.fmsevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {

    @Autowired
     EventRepository eventRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Flux<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Mono<DashboardResponseDTO> getDashboardInfo() {

        Mono<Long> totalEvents = eventRepository.count();
        Mono<Long> totalParticipants = employeeRepository.count();
        Mono<Integer> totalLivesImpacted = eventRepository.getLivesImpacted();
        Mono<Integer> totalVolunteers = eventRepository.getTotalVolunteers();

        return Mono.zip(totalEvents, totalLivesImpacted, totalParticipants,
        totalVolunteers).flatMap(data -> {
            data.getT1();
            data.getT2();
            data.getT3();
            data.getT4();
            return Mono.just(new DashboardResponseDTO(data.getT1(), data.getT2(), data.getT3(),
            data.getT4()));
        });
    }
}
