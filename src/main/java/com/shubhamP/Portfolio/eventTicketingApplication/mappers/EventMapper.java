package com.shubhamP.Portfolio.eventTicketingApplication.mappers;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateEventRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateTicketTypeRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.dtos.*;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

}
