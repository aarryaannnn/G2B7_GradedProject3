package com.G2B2.gl.tckttrckr.TicketTrackerApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.G2B2.gl.tckttrckr.TicketTrackerApplication.model.Ticket;
import com.G2B2.gl.tckttrckr.TicketTrackerApplication.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
//		System.out.println(result.get().getTitle());

		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Given ticket, not present the, with id: " + id);
		}
	}

	@Override
	public void saveTicket(Ticket theTicket) {
		ticketRepository.save(theTicket);
	}

	@Override
	public void deleteById(int id) {
		ticketRepository.deleteById(id);

	}

}
