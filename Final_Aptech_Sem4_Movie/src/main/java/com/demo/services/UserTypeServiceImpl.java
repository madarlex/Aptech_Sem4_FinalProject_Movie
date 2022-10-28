package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.models.Usertype;
import com.demo.repositories.MovieRepository;
import com.demo.repositories.UserTypeRepository;





@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Override
	public Usertype find(int id) {
		return userTypeRepository.findById(id).get();
	}
	


}
