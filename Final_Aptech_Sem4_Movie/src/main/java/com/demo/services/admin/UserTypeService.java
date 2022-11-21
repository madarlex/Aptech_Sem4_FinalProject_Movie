package com.demo.services.admin;

import java.util.Date;
import java.util.List;

//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Usertype;


public interface UserTypeService {

	public Iterable<Usertype> findAll();
	
}

