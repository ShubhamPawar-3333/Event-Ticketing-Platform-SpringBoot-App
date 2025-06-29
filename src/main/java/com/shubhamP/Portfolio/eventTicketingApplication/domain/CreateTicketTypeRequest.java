package com.shubhamP.Portfolio.eventTicketingApplication.domain;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequest {
    private String name;
    private Double price;
    private String description;
    private Integer totalAvailable;
}