package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.demo.models.AvailableSeats;

import com.demo.models.Ticket;




public interface TicketService {

<<<<<<< HEAD

=======
	public List<Ticket> findAllByUserId(int user_id);
	
>>>>>>> e14c949 (user template)
}
