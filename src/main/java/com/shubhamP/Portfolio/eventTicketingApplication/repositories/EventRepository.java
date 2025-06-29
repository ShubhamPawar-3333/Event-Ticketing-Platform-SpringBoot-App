package com.shubhamP.Portfolio.eventTicketingApplication.repositories;

import com.shubhamP.Portfolio.eventTicketingApplication.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID > {
}