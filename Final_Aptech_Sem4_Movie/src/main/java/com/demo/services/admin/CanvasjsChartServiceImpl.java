package com.demo.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.daos.*;
import com.demo.models.Movie;
import com.demo.models.MovieInfo;
import com.demo.models.PriceByDate;
import com.demo.models.PriceByMovie;
 
@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
 
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TicketService ticketService;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		List<String> analyzeGetMovie = ticketService.analyzeTotalBookingByMovieGetMovie();
		List<String> analyzeGetBooking = ticketService.analyzeTotalBookingByMovieGetBooking();
		List<MovieInfo> analyzeListMovie = new ArrayList<>();
		MovieInfo info = null;
		boolean found = false;
		for (int i = 0; i < analyzeGetMovie.size(); i++) {
			info = new MovieInfo(Integer.parseInt(analyzeGetMovie.get(i)), Integer.parseInt(analyzeGetBooking.get(i)));
			analyzeListMovie.add(info);
		}
		for (int i = 0; i < movieService.findMovieByNowShowing().size(); i++) {
			Movie movie = movieService.findMovieByNowShowing().get(i);
			for (int j = 0; j < analyzeListMovie.size(); j++) {
				MovieInfo movieInfo = analyzeListMovie.get(j);
				if (movieInfo.getMovieId() == movie.getId()) {
					found = true;
					map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", movieInfo.getBooking()); dataPoints1.add(map);
				}
			}
			if (found == false) {
				map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", 0); dataPoints1.add(map);
			}
			found = false;
		}
		//map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", a + 3); dataPoints1.add(map);
		list.add(dataPoints1);
		System.out.println("length: " + list.size());
		return list;
		//return canvasjsChartDao.getCanvasjsChartData();
	}

	@Override
	public List<List<Map<Object, Object>>> getColumnChartData() {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		List<String> analyzeGetDate = ticketService.analyzeTotalPriceBookingByDateGetDate();
		List<String> analyzeGetPrice = ticketService.analyzeTotalPriceBookingByDateGetPrice();
		List<PriceByDate> analyzeListPriceByDate = new ArrayList<>();
		PriceByDate priceByDate = null;
		boolean found = false;
		List<String> listDate = new ArrayList<>();
		listDate.add("2022-11-20");listDate.add("2022-11-21");listDate.add("2022-11-22");listDate.add("2022-11-23");listDate.add("2022-11-24");
		listDate.add("2022-11-25");listDate.add("2022-11-26");listDate.add("2022-11-27");listDate.add("2022-11-28");listDate.add("2022-11-29");
		listDate.add("2022-11-30");listDate.add("2022-12-01");listDate.add("2022-12-02");listDate.add("2022-12-03");listDate.add("2022-12-04");
		for (int i = 0; i < analyzeGetDate.size(); i++) {
			priceByDate = new PriceByDate(analyzeGetDate.get(i), Double.parseDouble(analyzeGetPrice.get(i)));
			analyzeListPriceByDate.add(priceByDate);
		}
		for (int i = 0; i < listDate.size(); i++) {
			String date = listDate.get(i);
			for (int j = 0; j < analyzeListPriceByDate.size(); j++) {
				PriceByDate dbDate = analyzeListPriceByDate.get(j);
				if (date.equals(dbDate.getDate())) {
					found = true;
					map = new HashMap<Object,Object>(); map.put("label", date); map.put("y", dbDate.getTotal()); dataPoints1.add(map);
				}
			}
			if (found == false) {
				map = new HashMap<Object,Object>(); map.put("label", date); map.put("y", 0); dataPoints1.add(map);
			}
			found = false;
		}
		//map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", a + 3); dataPoints1.add(map);
		list.add(dataPoints1);
		return list;
	}

	@Override
	public List<List<Map<Object, Object>>> getLineChartData() {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		List<String> analyzeGetMovie = ticketService.analyzeTotalPriceBookingByMovieGetMovie();
		System.out.println("movie: " + analyzeGetMovie.size());
		List<String> analyzeGetPrice = ticketService.analyzeTotalPriceBookingByMovieGetPrice();
		System.out.println("price: " + analyzeGetPrice.size());
		List<PriceByMovie> analyzeListPriceByMovie = new ArrayList<>();
		PriceByMovie priceByMovie = null;
		boolean found = false;
		for (int i = 0; i < analyzeGetMovie.size(); i++) {
			priceByMovie = new PriceByMovie(movieService.findById(Integer.parseInt(analyzeGetMovie.get(i))), Double.parseDouble(analyzeGetPrice.get(i)));
			analyzeListPriceByMovie.add(priceByMovie);
		}
		for (int i = 0; i < movieService.findMovieByNowShowing().size(); i++) {
			Movie movie = movieService.findMovieByNowShowing().get(i);
			for (int j = 0; j < analyzeListPriceByMovie.size(); j++) {
				PriceByMovie movieInfo = analyzeListPriceByMovie.get(j);
				if (movieInfo.getMovie().getId() == movie.getId()) {
					found = true;
					map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", movieInfo.getTotal()); dataPoints1.add(map);
				}
			}
			if (found == false) {
				map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", 0); dataPoints1.add(map);
			}
			found = false;
		}
		//map = new HashMap<Object,Object>(); map.put("label", movie.getName()); map.put("y", a + 3); dataPoints1.add(map);
		list.add(dataPoints1);
		return list;
	}
 
}  
