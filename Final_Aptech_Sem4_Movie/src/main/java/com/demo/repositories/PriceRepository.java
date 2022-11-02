package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer>{

	@Query("from Price where description like :day")
	public Price findByDescription(@Param("day") String day);

}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
