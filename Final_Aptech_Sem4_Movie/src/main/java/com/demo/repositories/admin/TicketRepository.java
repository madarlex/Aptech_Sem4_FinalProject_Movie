package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Ticket;
import com.demo.models.TicketPriceDetail;
import com.demo.models.AvailableSeats;
import com.demo.models.MovieInfo;
import com.demo.models.Movieshowtime;

@Repository("AdminTicketRepository")
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>{
	
	@Query("from Ticket where user_id = :user_id")
	public List<Ticket> findAllByUserId(@Param("user_id") int user_id);
	
	@Query("from Ticket where id = :id")
	public Ticket findById(@Param("id") int id);
	
	@Query(value = "select * from Ticket where status = 1",nativeQuery = true)
	public Page<Ticket> findAllByStatus(Pageable pageable);
	
	@Query("from TicketPriceDetail where ticket_id = :ticket_id")
	public TicketPriceDetail findAllDetailByTicketId(@Param("ticket_id") int ticketId);
	
	@Query(value = "SELECT COUNT(*) FROM `ticket` as t join movieshowtime as m on t.movie_show_time_id = m.id where m.show_date = :today", nativeQuery = true)
	public int countTicket(@Param("today") String today);
	
	@Query(value = "SELECT mv.id FROM `ticket` as t join movieshowtime as m on t.movie_show_time_id = m.id left join movie as mv on m.movie_id = mv.id group by mv.id order by mv.id", nativeQuery = true)
	public List<String> analyzeTotalBookingByMovieGetMovie();
	
	@Query(value = "SELECT count(mv.id) FROM `ticket` as t join movieshowtime as m on t.movie_show_time_id = m.id left join movie as mv on m.movie_id = mv.id group by mv.id order by mv.id", nativeQuery = true)
	public List<String> analyzeTotalBookingByMovieGetBooking();
	
	@Query(value = "select m.show_date from ticket as t join ticket_price_detail as tp on t.id = tp.ticket_id join movieshowtime as m on t.movie_show_time_id = m.id join price as p on p.id = tp.price_id WHERE m.show_date <= '2022-12-30' and m.show_date >= '2022-11-01' group by m.show_date ORDER by m.id", nativeQuery = true)
	public List<String> analyzeTotalPriceBookingByDateGetDate();
	
	@Query(value = "select sum(p.price) from ticket as t join ticket_price_detail as tp on t.id = tp.ticket_id join movieshowtime as m on t.movie_show_time_id = m.id join price as p on p.id = tp.price_id WHERE m.show_date <= '2022-12-30' and m.show_date >= '2022-11-01' group by m.show_date ORDER by m.id", nativeQuery = true)
	public List<String> analyzeTotalPriceBookingByDateGetPrice();
	
	
	@Query(value = "select sum(p.price) from ticket as t join ticket_price_detail as tp on t.id = tp.ticket_id join movieshowtime as m on t.movie_show_time_id = m.id join price as p on p.id = tp.price_id join movie as mv on mv.id = m.movie_id WHERE mv.now_showing = 1 group by mv.id order by mv.id", nativeQuery = true)
	public List<String> analyzeTotalPriceBookingByMovieGetPrice();
	
	@Query(value = "select mv.id from ticket as t join ticket_price_detail as tp on t.id = tp.ticket_id join movieshowtime as m on t.movie_show_time_id = m.id join price as p on p.id = tp.price_id join movie as mv on mv.id = m.movie_id WHERE mv.now_showing = 1 group by mv.id order by mv.id", nativeQuery = true)
	public List<String> analyzeTotalPriceBookingByMovieGetMovie();
	
	@Query("from Ticket where movieshowtime.id = :id")
	public List<Ticket> findByMovieshowtime(@Param("id") int id);
	
	@Query(value = "select sum(p.price) from ticket as t join ticket_price_detail as tp on t.id = tp.ticket_id join movieshowtime as m on t.movie_show_time_id = m.id join price as p on p.id = tp.price_id", nativeQuery = true)
	public double getTotalRevenue();
	
	@Query( value = "select * from ticket WHERE user_id = :accountID", nativeQuery = true)
	public List<Ticket> findByAccount(@Param("accountID") String id);
}

