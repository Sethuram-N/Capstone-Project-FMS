package com.capstone.fmsevent.repository;

import com.capstone.fmsevent.entity.Event;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, String> {

    @Query("Select sum(livesImpacted) from Event")
    Mono<Integer> getLivesImpacted();

    @Query("Select sum(totalVolunteers) from Event")
    Mono<Integer> getTotalVolunteers();
}
