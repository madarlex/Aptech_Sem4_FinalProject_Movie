package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.models.Ticket;
import com.demo.models.TicketPriceDetail;




public interface TicketPriceDetailService {

	public TicketPriceDetail save(TicketPriceDetail ticketPriceDetail);
	
}
