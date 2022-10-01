package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository; 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.demo.models.Hall;
import com.demo.models.Movie;

@Repository("AdminHallRepository")
public interface HallRepository extends PagingAndSortingRepository<Hall, Long>{

	@Query("from Hall where id = :id")
	public Hall findById(@Param("id")int id);


}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
