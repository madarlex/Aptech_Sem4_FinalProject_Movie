package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.AdminAvailableSeats;
import com.demo.models.AvailableSeats;
import com.demo.models.Seat;
import com.demo.repositories.admin.SeatRepository;
import com.demo.repositories.admin.TicketRepository;





@Service("AdminseatService")
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	

	@Override
	public Iterable<AdminAvailableSeats> getAdminAvailableSeats(int hall_id, int movie_show_time_id) {
		// TODO Auto-generated method stub
		return seatRepository.getAdminAvailableSeats(hall_id, movie_show_time_id);
	}


	@Override
	public Seat findById(int id) {
		// TODO Auto-generated method stub
		return seatRepository.findById(id).get();
	}

}
