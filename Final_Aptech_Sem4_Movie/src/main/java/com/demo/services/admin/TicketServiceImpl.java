package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.models.Ticket;
import com.demo.repositories.admin.MovieRepository;
import com.demo.repositories.admin.TicketRepository;
import com.demo.models.AvailableSeats;
import com.demo.models.Hall;





@Service("AdminTicketService")
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

	@Override
	public Page<Ticket> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1, 20);
		return ticketRepository.findAllByStatus(pageable);
	}

	@Override
	public Ticket findById(int id) {
		return ticketRepository.findById(id);
	}


}
