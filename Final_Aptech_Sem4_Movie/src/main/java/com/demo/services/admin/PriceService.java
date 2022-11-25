package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.demo.models.Hall;
import com.demo.models.Price;




public interface PriceService {

	public Price findByDescription(Date showDate); 
	
	public Page<Price> findAll(int numberPage);
	
	public boolean create (Price price);
	
	public Price findById (long id);
	
	public boolean delete (int id);
}
