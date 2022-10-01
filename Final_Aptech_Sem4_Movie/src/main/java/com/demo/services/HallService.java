package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.models.Seat;




public interface HallService {

	public Hall findById(int id);
	
}
