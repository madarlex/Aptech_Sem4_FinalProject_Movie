package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.demo.models.Usertype;

@Repository
public interface UserTypeRepository extends CrudRepository<Usertype, Integer>{



}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
