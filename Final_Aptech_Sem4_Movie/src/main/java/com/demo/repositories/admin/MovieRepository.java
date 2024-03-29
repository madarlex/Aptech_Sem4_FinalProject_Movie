package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository; 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.demo.models.Movie;

@Repository("AdminMovieRepository")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long>{

	@Query("from Movie where id = :id")
	public Movie findMovieById(@Param("id")int id);

	@Query("from Movie where start_date <= :start and end_date >= :end")
	public List<Movie> findMovieByTime(@Param("start") Date start, @Param("end") Date end);
	
	@Query("from Movie where now_showing = true")
	public List<Movie> findMovieByNowShowing();
	
	@Query("from Movie where end_date >= :today")
	public List<Movie> findMovieByTimeFromToday(@Param("today") Date today);
	
	@Query(value = "SELECT COUNT(*) from movie where now_showing = 1", nativeQuery = true)
	public int countMovieNowShowing();
	
	@Query("from Movie where name like %:keyword%")
	public List<Movie> findByKeyWord(@Param("keyword") String keyword);
}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
