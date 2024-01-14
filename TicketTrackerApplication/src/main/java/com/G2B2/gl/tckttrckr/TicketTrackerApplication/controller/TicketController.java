package com.G2B2.gl.tckttrckr.TicketTrackerApplication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.G2B2.gl.tckttrckr.TicketTrackerApplication.model.Ticket;
import com.G2B2.gl.tckttrckr.TicketTrackerApplication.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
//	TicketService ticketService = new TicketServiceImpl();
	
	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.findAll();
			model.addAttribute("tickets", tickets);
		return "tickets/list-tickets";
	}
	
	@GetMapping("/new-ticket")
	public String newTicket(Model model ) {
		Ticket newTicket = new Ticket();
		model.addAttribute("ticket", newTicket);
		return "tickets/new-ticket";
	}
	
	@GetMapping("/edit-ticket/{id}")
	public String editTicket(Model model, @PathVariable int id) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("ticket", ticket);
		return "tickets/edit-ticket";
	}
	
	@PostMapping("/create-ticket")
	public String createTicket(Model model, @ModelAttribute("ticket") Ticket ticket) {
		ticket.setCreateOn(new Date());
		ticketService.saveTicket(ticket);
		return "redirect:list";
	}
	
	@GetMapping("/delete-ticket/{id}")
	public String deleteTicket(@PathVariable int id) {
//		public String deleteTicket() {
		ticketService.deleteById(id);
		return "redirect:/tickets/list";
	}
	
	@PostMapping("/update-ticket")
	public String updateTicket(Model model, @ModelAttribute("ticket") Ticket ticket) {
//		System.out.println(ticket.getId());
//		Ticket t = ticketService.findById(ticket.getId());
		ticket.setCreateOn(new Date());
	    ticketService.saveTicket(ticket);
	    return "redirect:/tickets/list"; 
	}
	
	@GetMapping("/view-ticket/{id}")
	public String viewTicket(Model model, @PathVariable int id ) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("ticket", ticket);
		return "/tickets/view-ticket";
	}
	
	@GetMapping("/searched-ticket")
	public String searchTickets(Model model, @RequestParam String search){
		List<Ticket> tickets = ticketService.findAll();
		
		String searchInput = search;
		
		System.out.println(search);
		
		
		if(!searchInput.isEmpty()) {
			List<Ticket> filteredTickets = new ArrayList<>();

	        for (Ticket ticket : tickets) {
	            if (ticket.getTitle().equals(searchInput)) {
	                filteredTickets.add(ticket);
	            }
	        }
	        model.addAttribute("tickets", filteredTickets);
		}
		
		else {
			model.addAttribute("tickets", tickets);
		}
		
		return "/tickets/searched-ticket";
	}
}
