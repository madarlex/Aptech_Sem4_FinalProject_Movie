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

import com.demo.models.Account;
import com.demo.models.Feedback;
import com.demo.models.Movie;
import com.demo.models.Movieshowtime;

@Repository("AdminMovieshowtimeRepository")
public interface MovieshowtimeRepository extends PagingAndSortingRepository<Movieshowtime, Integer>{
	
	@Query(value="Select * from Movieshowtime as m where movie_id = :movieId order by m.show_date desc, m.show_time desc",nativeQuery = true)
	public List<Movieshowtime> findShowtimemovieByMovieId(@Param("movieId") int movieId);
	
	@Query(value = "select * from Movieshowtime where status = 1",nativeQuery = true)
	public Page<Movieshowtime> findAllByStatus(Pageable pageable);
	
	@Query("from Movieshowtime where id = :id")
	public Movieshowtime findById(@Param("id") int id);
	
	@Query(value="Select * from Movieshowtime as m where m.movie_id = :movieId and m.show_date = :date order by m.show_time desc",nativeQuery = true)
	public List<Movieshowtime> findShowtimemovieByMovieIdAndByDate(@Param("movieId") int movieId, @Param("date") Date date);
	
	@Query(value = "SELECT count(*) as check_available from Movieshowtime WHERE hall_id = :hall_id and show_date = :show_date and (show_time >= :show_time or end_time >= :end_time) and status != 0", nativeQuery = true)
	public int checkValidateHallAndShowTime(@Param("hall_id") int hallId, @Param("show_date") String showDate, @Param("show_time") String showTime, @Param("end_time") String endTime);
	
//	@Query("select distinct movie_id from Movieshowtime where show_date = :date")
//	public List<Movieshowtime> findShowTimeByDate(@Param("date") Date date);
}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
