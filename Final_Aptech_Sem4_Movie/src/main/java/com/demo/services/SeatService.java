package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.models.AvailableSeats;
import com.demo.models.Movie;
import com.demo.models.Seat;




public interface SeatService {


	public Iterable<AvailableSeats> getAvailableSeats(int hall_id, int movie_show_time_id);
	public Seat findById(int id);
}
