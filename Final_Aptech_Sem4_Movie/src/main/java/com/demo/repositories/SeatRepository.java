package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.demo.models.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer>{



}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
