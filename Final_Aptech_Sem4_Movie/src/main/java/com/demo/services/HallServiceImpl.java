package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.repositories.HallRepository;
import com.demo.repositories.SeatRepository;





@Service
public class HallServiceImpl implements HallService {
	
	@Autowired
	private HallRepository hallRepository;
	
	@Override
	public Hall findById(int id) {
		// TODO Auto-generated method stub
		return hallRepository.findById(id).get();
	}
	


}
