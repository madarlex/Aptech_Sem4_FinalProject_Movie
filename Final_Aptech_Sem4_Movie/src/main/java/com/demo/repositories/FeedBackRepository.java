package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Feedback;


@Repository
public interface FeedBackRepository extends CrudRepository<Feedback, Integer>{
	
	@Query("from Feedback where status=1 and movie_id = :movie_id")
	public List<Feedback> findAllFeedbackByMovie(@Param("movie_id") int movie_id);


}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
