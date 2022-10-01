package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.AvailableSeats;
import com.demo.models.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer>{

	@Query(nativeQuery = true)
	public Iterable<AvailableSeats> getAvailableSeats(int hall_id, int movie_show_time_id);

}
