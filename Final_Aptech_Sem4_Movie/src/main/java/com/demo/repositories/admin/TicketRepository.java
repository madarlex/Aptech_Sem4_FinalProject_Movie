package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Ticket;
import com.demo.models.AvailableSeats;
import com.demo.models.Movieshowtime;

@Repository("AdminTicketRepository")
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>{
	
	@Query("from Ticket where user_id = :user_id")
	public List<Ticket> findAllByUserId(@Param("user_id") int user_id);
	
	@Query("from Ticket where id = :id")
	public Ticket findById(@Param("id") int id);
	
	@Query(value = "select * from Ticket where status = 1",nativeQuery = true)
	public Page<Ticket> findAllByStatus(Pageable pageable);

}

