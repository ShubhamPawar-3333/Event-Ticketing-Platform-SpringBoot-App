package com.shubhamP.Portfolio.eventTicketingApplication.services;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateEventRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId,  CreateEventRequest event);
    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);
    Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);
}
