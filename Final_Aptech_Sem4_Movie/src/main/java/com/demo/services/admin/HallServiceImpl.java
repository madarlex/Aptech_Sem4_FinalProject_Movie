package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.repositories.admin.HallRepository;





@Service("AdminHallImplService")
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepository hallRepository;
		
	@Override
	public Iterable<Hall> findAll() {
		return hallRepository.findAll();
	}

	@Override
	public boolean create(Hall hall) {
		try {
			hallRepository.save(hall);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Page<Hall> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 5);
		return hallRepository.findAll(pageable);
	}

	@Override
	public Hall findById(int id) {
		return hallRepository.findById(id);
	}

	@Override
	public void delete(Hall hall) {
		hallRepository.delete(hall);
	}
	


}
