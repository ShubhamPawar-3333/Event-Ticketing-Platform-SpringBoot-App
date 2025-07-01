package com.shubhamP.Portfolio.eventTicketingApplication.mappers;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateEventRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.CreateTicketTypeRequest;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import com.shubhamP.Portfolio.eventTicketingApplication.dtos.CreateEventRequestDto;
import com.shubhamP.Portfolio.eventTicketingApplication.dtos.CreateEventResponseDto;
import com.shubhamP.Portfolio.eventTicketingApplication.dtos.CreateTicketTypeRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

}