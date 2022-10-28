package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Movie;


@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer>{
	
	@Query("from Movie where status=1")
	public List<Movie> findAllActiveMovie();
	
	@Query("from Movie where hotMovie=1")
	public List<Movie> findAllHotMovie();
	
	@Query("from Movie where comingSoon=1")
	public List<Movie> findAllComingSoonMovie();

	@Query(value = "select * from movie order by rate desc limit 5", nativeQuery = true)
	public List<Movie> findAllorderByRateLimitMovie();
	
	@Query(value = "select count(*) from movie", nativeQuery = true)
	public int countMovieRecord();
	
	@Query("from Movie where name like %:keyword%")
	public List<Movie> findMovieByKeyword(@Param("keyword") String keyword);

}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
