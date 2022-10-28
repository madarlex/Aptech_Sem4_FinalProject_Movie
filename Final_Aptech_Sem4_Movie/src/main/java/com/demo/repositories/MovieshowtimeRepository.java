package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Movie;
import com.demo.models.Movieshowtime;

@Repository
public interface MovieshowtimeRepository extends CrudRepository<Movieshowtime, Integer>{
	
	@Query("from Movieshowtime where movieId= :movieId ")
	public List<Movie> findShowtimemovieByMovieId(@Param("movieId") int movieId);
}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
