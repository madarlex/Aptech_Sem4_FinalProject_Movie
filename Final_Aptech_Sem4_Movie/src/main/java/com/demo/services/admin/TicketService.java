package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.AvailableSeats;
import com.demo.models.Hall;
import com.demo.models.Ticket;
import com.demo.models.TicketPriceDetail;




public interface TicketService {


	public Ticket save(Ticket ticket);
	public List<Ticket> findAllByUserId(int user_id);
	public Page<Ticket> findAll(int numberPage);
	public Ticket findById(int id);
	public TicketPriceDetail findAllDetailByTicketId(int ticketId);
	public void deleteDetail (TicketPriceDetail detail);
	public void deleteTicket(Ticket ticket);

}
