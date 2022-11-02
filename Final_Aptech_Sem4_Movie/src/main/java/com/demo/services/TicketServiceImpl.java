package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Ticket;
import com.demo.repositories.MovieRepository;
import com.demo.models.AvailableSeats;
import com.demo.repositories.TicketRepository;





@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> findAllByUserId(int user_id) {
		return ticketRepository.findAllByUserId(user_id);
	}

	@Override
	public Ticket save(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}
	


}
