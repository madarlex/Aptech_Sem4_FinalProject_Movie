package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.models.Movie;



@Service("AdminHallService")
public interface HallService {

	public Iterable<Hall> findAll();
	
	public boolean create(Hall hall);
	
	public Page<Hall> findAll(int numberPage);
	
	public Hall findById(int id);
	
	public void delete(Hall hall);
}
