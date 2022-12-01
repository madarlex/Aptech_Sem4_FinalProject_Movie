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

@Repository("AdminFeedbackRepository")
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Integer>{

	@Query(value = "select * from feedback where movie_id = :movieid",nativeQuery = true)
	public List<Feedback> findAllFeedbackByMoiveid(@Param("movieid")int movieid);
	
	@Query("from Feedback where id = :id")
	public Feedback findFeedbackById(@Param("id")int id);

}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
