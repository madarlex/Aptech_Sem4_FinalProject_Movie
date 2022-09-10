package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.demo.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{



}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
