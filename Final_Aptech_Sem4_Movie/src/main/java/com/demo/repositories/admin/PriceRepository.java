package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Price;

@Repository("AdminPriceRepository")
public interface PriceRepository extends PagingAndSortingRepository<Price, Integer>{

	@Query("from Price where description like :day")
	public Price findByDescription(@Param("day") String day);
	
	@Query("from Price where id = :id")
	public Price findById(@Param("id") int id);

}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
