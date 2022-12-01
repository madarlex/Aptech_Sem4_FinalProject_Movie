package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.models.AdminAvailableSeats;
import com.demo.models.Movie;
import com.demo.models.MovieSchedule;
import com.demo.models.Movieshowtime;
import com.demo.models.ShowTimeAvailableSeats;
import com.demo.repositories.admin.MovieRepository;
import com.demo.repositories.admin.MovieshowtimeRepository;





@Service("AdminMovieshowtimeService")
public class MovieshowtimeServiceImpl implements MovieshowtimeService {

	@Autowired
	private MovieshowtimeRepository movieshowtimeRepository;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SeatService seatService;
	
	@Override
	public Iterable<Movieshowtime> findAll() {
		return movieshowtimeRepository.findAll();
	}

	@Override
	public List<Movieshowtime> findShowtimemovieByMovieId(int movieId) {
		return movieshowtimeRepository.findShowtimemovieByMovieId(movieId);
	}


	@Override
	public Page<Movieshowtime> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 20);
		return movieshowtimeRepository.findAllByStatus(pageable);
	}

	@Override
	public boolean create(Movieshowtime movieshowtime) {
		if (movieshowtimeRepository.save(movieshowtime) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Movieshowtime> findShowtimemovieByMovieIdAndByDate(int movieId, Date date) {
		return movieshowtimeRepository.findShowtimemovieByMovieIdAndByDate(movieId, date);
	}

	@Override
	public Movieshowtime findById(int id) {
		return movieshowtimeRepository.findById(id);
	}

	@Override
	public void delete(Movieshowtime showtime) {
		movieshowtimeRepository.delete(showtime);
	}

	@Override
	public int checkValidateHallAndShowTime(int hallId, String showDate, String showTime, String endTime) {
		return movieshowtimeRepository.checkValidateHallAndShowTime(hallId, showDate, showTime, endTime);
	}

	@Override
	public List<String> getMovieNowShowingHasSchedule() {
		return movieshowtimeRepository.getMovieNowShowingHasSchedule();
	}

	@Override
	public List<MovieSchedule> getScheduleOfMovieNowShowing() {
		List<Movieshowtime> listAllNowShowing = findAllScheduleNowShowing();
		List<String> movieNowShowingHasSchedule = getMovieNowShowingHasSchedule();
		Movie movie = null;
		Movieshowtime movieshowtime = null;
		MovieSchedule movieSchedule = null;
		List<MovieSchedule> schedules = new ArrayList<>();
		ShowTimeAvailableSeats showTimeAvailableSeats = null;
		for (int i = 0; i < movieNowShowingHasSchedule.size(); i++) {
			movie = movieService.findById(Integer.parseInt(movieNowShowingHasSchedule.get(i)));
			movieSchedule = new MovieSchedule();
			movieSchedule.setMovie(movie);
			for (int j = 0; j < listAllNowShowing.size(); j++) {
				movieshowtime = listAllNowShowing.get(j);
				if (movie.getId() == movieshowtime.getMovie().getId()) {
					List<AdminAvailableSeats> availableSeats = (List<AdminAvailableSeats>) seatService.getAdminAvailableSeats(movieshowtime.getHall().getId(), movieshowtime.getId());
					showTimeAvailableSeats = new ShowTimeAvailableSeats();
					showTimeAvailableSeats.setAvailableSeats(availableSeats.size());
					showTimeAvailableSeats.setMovieshowtime(movieshowtime);
					movieSchedule.getMovieshowtimes().add(showTimeAvailableSeats);
				}
			}
			schedules.add(movieSchedule);
		}
		return schedules;
	}

	@Override
	public List<Movieshowtime> findAllScheduleNowShowing() {
		return movieshowtimeRepository.findAllScheduleNowShowing();
	}
	
	@Override
	public List<Movieshowtime> findShowtimeByDate(String date) {
		return movieshowtimeRepository.findByDate(date);
	}

	@Override
	public List<Movieshowtime> findByKeyword(String keyword) {
		return movieshowtimeRepository.findByKeyword(keyword);
	}
	
//	@Override
//	public List<Movieshowtime> findShowtimeByDate(Date date) {
//		return movieshowtimeRepository.findShowTimeByDate(date);
//	}

}
