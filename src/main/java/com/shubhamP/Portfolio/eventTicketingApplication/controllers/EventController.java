package com.shubhamP.Portfolio.eventTicketingApplication.controllers;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateEventRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.GetEventDetailsResponseDto;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.ListEventResponseDto;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.CreateEventRequestDto;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.CreateEventResponseDto;
import com.shubhamP.Portfolio.eventTicketingApplication.mappers.EventMapper;
import com.shubhamP.Portfolio.eventTicketingApplication.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<CreateEventResponseDto> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDto createEventRequestDto){
        CreateEventRequest createEventRequest = eventMapper.fromDto(createEventRequestDto);
        UUID userId = parseUserId(jwt);

        Event createdEvent = eventService.createEvent(userId, createEventRequest);
        CreateEventResponseDto createEventResponsedto = eventMapper.toDto(createdEvent);

        return new ResponseEntity<>(createEventResponsedto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ListEventResponseDto>> listEvents(
            @AuthenticationPrincipal Jwt jwt, Pageable pageable) {
        UUID userId = parseUserId(jwt);
        Page<Event> events = eventService.listEventsForOrganizer(userId, pageable);
        return ResponseEntity.ok(
                events.map(eventMapper::toListEventResponseDto)
        );
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<GetEventDetailsResponseDto> getEvent(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID eventId
    ) {
        UUID userId = parseUserId(jwt);
        return eventService.getEventForOrganizer(userId, eventId)
                .map(eventMapper::toGetEventDetailsResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private UUID parseUserId(Jwt jwt){
        return UUID.fromString(jwt.getSubject());
    }
}
