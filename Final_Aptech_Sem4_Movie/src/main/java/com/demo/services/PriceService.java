package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.models.Price;




public interface PriceService {

	public Price findByDescription(Date showDate); 
	public Price create (Price price);
}
