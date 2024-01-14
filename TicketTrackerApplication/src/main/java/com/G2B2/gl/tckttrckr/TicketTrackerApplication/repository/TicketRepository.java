package com.G2B2.gl.tckttrckr.TicketTrackerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.G2B2.gl.tckttrckr.TicketTrackerApplication.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
