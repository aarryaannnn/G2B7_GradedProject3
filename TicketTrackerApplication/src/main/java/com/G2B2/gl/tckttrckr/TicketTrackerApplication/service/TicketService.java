package com.G2B2.gl.tckttrckr.TicketTrackerApplication.service;

import java.util.List;

import com.G2B2.gl.tckttrckr.TicketTrackerApplication.model.Ticket;

public interface TicketService {
	public List<Ticket> findAll();

	public Ticket findById(int id);

	public void saveTicket(Ticket theTicket);

	public void deleteById(int id);
}
