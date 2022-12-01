package com.demo.services.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.models.Ticket;
import com.demo.models.TicketPriceDetail;
import com.demo.repositories.admin.MovieRepository;
import com.demo.repositories.admin.TicketRepository;
import com.demo.repositories.TicketPriceDetailRepository;
import com.demo.models.AvailableSeats;
import com.demo.models.Hall;
import com.demo.models.MovieInfo;
import com.demo.models.PriceByDate;





@Service("AdminTicketService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TicketPriceDetailRepository detailRepository;
	
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

	@Override
	public TicketPriceDetail findAllDetailByTicketId(int ticketId) {
		return ticketRepository.findAllDetailByTicketId(ticketId);
	}

	@Override
	public void deleteDetail(TicketPriceDetail detail) {
		detailRepository.delete(detail);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
	}

	@Override
	public int countTicket(Date date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String today = dateFormat.format(date);
			return ticketRepository.countTicket(today);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<String> analyzeTotalBookingByMovieGetMovie() {
		return ticketRepository.analyzeTotalBookingByMovieGetMovie();
	}

	@Override
	public List<String> analyzeTotalBookingByMovieGetBooking() {
		return ticketRepository.analyzeTotalBookingByMovieGetBooking();
	}

	@Override
	public List<Ticket> findByMovieshowtime(int id) {
		return ticketRepository.findByMovieshowtime(id);
	}

	@Override
	public List<String> analyzeTotalPriceBookingByDateGetDate() {
		return ticketRepository.analyzeTotalPriceBookingByDateGetDate();
	}

	@Override
	public List<String> analyzeTotalPriceBookingByDateGetPrice() {
		return ticketRepository.analyzeTotalPriceBookingByDateGetPrice();
	}

	@Override
	public double getTotalRevenue() {
		return ticketRepository.getTotalRevenue();
	}

	@Override
	public List<Ticket> findByAccount(String id) {
		return ticketRepository.findByAccount(id);
	}

	@Override
	public List<String> analyzeTotalPriceBookingByMovieGetPrice() {
		return ticketRepository.analyzeTotalPriceBookingByMovieGetPrice();
	}

	@Override
	public List<String> analyzeTotalPriceBookingByMovieGetMovie() {
		return ticketRepository.analyzeTotalPriceBookingByMovieGetMovie();
	}
}
