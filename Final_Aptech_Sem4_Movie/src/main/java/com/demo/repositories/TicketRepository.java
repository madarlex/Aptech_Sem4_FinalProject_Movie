package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Ticket;
import com.demo.models.AvailableSeats;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	
	@Query("from Ticket where user_id = :user_id")
	public List<Ticket> findAllByUserId(@Param("user_id") int user_id);

}

