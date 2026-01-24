package com.shubhamP.Portfolio.eventTicketingApplication.controllers;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.ListPublishedEventResponseDto;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import com.shubhamP.Portfolio.eventTicketingApplication.mappers.EventMapper;
import com.shubhamP.Portfolio.eventTicketingApplication.repositories.EventRepository;
import com.shubhamP.Portfolio.eventTicketingApplication.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventController {

    private final EventService eventService;
    private final EventMapper  eventMapper;
    private final EventRepository eventRepository;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventResponseDto>> listPublishedEvents(
            @RequestParam(required = false) String q,
            Pageable pageable) {

        Page<Event> events;
        if (q != null && !q.trim().isEmpty()) {
            events = eventService.searchPublishedEvents(q, pageable);
        } else {
            events = eventService.listPublishedEvents(pageable);
        }

        return ResponseEntity.ok(
                events.map(eventMapper::toListPublishedEventResponseDto)
        );
    }
}
