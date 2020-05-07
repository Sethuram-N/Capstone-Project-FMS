package com.capstone.fmsevent.handler;

import com.capstone.fmsevent.entity.Event;
import com.capstone.fmsevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class EventHandler {

    @Autowired
    EventRepository eventRepository;

    public Mono<ServerResponse> getEvents(ServerRequest serverRequest) {

        String id = serverRequest.pathVariable("id");
        Mono<Event> event =  eventRepository.findById(id);

        return event.flatMap(evt ->
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(evt)));
    }
}
