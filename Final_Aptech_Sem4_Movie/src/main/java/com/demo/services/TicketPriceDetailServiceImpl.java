package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.TicketPriceDetail;
import com.demo.repositories.TicketPriceDetailRepository;
import com.demo.repositories.TicketRepository;





@Service
public class TicketPriceDetailServiceImpl implements TicketPriceDetailService {

	@Autowired
	private TicketPriceDetailRepository ticketPriceDetailRepository;
	
	@Override
	public TicketPriceDetail save(TicketPriceDetail ticketPriceDetail) {
		// TODO Auto-generated method stub
		return ticketPriceDetailRepository.save(ticketPriceDetail);
	}
	


}
