package com.demo.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.models.Price;
import com.demo.repositories.PriceRepository;





@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public Price findByDescription(Date showDate) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.setTime(showDate);
		String shownDay = "";
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == c.MONDAY) {
			shownDay = "Monday";
		} else if (dayOfWeek == c.TUESDAY) {
			shownDay = "Tuesday";
		} else if (dayOfWeek == c.WEDNESDAY) {
			shownDay = "Wednesday";
		} else if (dayOfWeek == c.THURSDAY) {
			shownDay = "Thursday";
		} else if (dayOfWeek == c.FRIDAY) {
			shownDay = "Friday";
		} else if (dayOfWeek == c.SATURDAY) {
			shownDay = "Saturday";
		} else {
			shownDay = "Sunday";
		}
		return priceRepository.findByDescription(shownDay);
	}
	


}
