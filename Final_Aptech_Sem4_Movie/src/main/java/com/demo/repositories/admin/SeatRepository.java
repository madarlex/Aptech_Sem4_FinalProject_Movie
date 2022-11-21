package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.AdminAvailableSeats;
import com.demo.models.AvailableSeats;
import com.demo.models.Seat;

@Repository("AdminSeatRepository")
public interface SeatRepository extends CrudRepository<Seat, Integer>{

	@Query(nativeQuery = true)
	public Iterable<AdminAvailableSeats> getAdminAvailableSeats(int hall_id, int movie_show_time_id);

}
