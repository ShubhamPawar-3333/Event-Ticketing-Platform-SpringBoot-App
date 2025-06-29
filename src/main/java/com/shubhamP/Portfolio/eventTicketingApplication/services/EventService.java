package com.shubhamP.Portfolio.eventTicketingApplication.services;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateEventRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId,  CreateEventRequest event);
}