package com.demo.models;
// Generated Nov 2, 2022, 8:26:37 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OrderBy;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Movie generated by hbm2java
 */
@Entity
@Table(name = "movie")
public class Movie implements java.io.Serializable {

	private Integer id;
	private String name;
	private String shortName;
	private String trailer;
	private String picture;
	private String description;
	private Date startDate;
	private int rate;
	private boolean hotMovie;
	private boolean nowShowing;
	private boolean comingSoon;
	private int length;
	private Date endDate;
	private boolean status;
	private Set<Feedback> feedbacks = new HashSet<Feedback>(0);
	
	@OrderBy(clause = "movieshowtimes.showTime")
	private Set<Movieshowtime> movieshowtimes = new HashSet<Movieshowtime>(0);

	public Movie() {
	}

	public Movie(String name, String shortName, String trailer, String picture, String description, Date startDate,
			int rate, boolean hotMovie, boolean nowShowing, boolean comingSoon, int length, Date endDate,
			boolean status) {
		this.name = name;
		this.shortName = shortName;
		this.trailer = trailer;
		this.picture = picture;
		this.description = description;
		this.startDate = startDate;
		this.rate = rate;
		this.hotMovie = hotMovie;
		this.nowShowing = nowShowing;
		this.comingSoon = comingSoon;
		this.length = length;
		this.endDate = endDate;
		this.status = status;
	}

	public Movie(String name, String shortName, String trailer, String picture, String description, Date startDate,
			int rate, boolean hotMovie, boolean nowShowing, boolean comingSoon, int length, Date endDate,
			boolean status, Set<Feedback> feedbacks, Set<Movieshowtime> movieshowtimes) {
		this.name = name;
		this.shortName = shortName;
		this.trailer = trailer;
		this.picture = picture;
		this.description = description;
		this.startDate = startDate;
		this.rate = rate;
		this.hotMovie = hotMovie;
		this.nowShowing = nowShowing;
		this.comingSoon = comingSoon;
		this.length = length;
		this.endDate = endDate;
		this.status = status;
		this.feedbacks = feedbacks;
		this.movieshowtimes = movieshowtimes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "short_name", nullable = false, length = 250)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "trailer", nullable = false, length = 250)
	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Column(name = "picture", nullable = false, length = 250)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "rate", nullable = false)
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Column(name = "hot_movie", nullable = false)
	public boolean isHotMovie() {
		return this.hotMovie;
	}

	public void setHotMovie(boolean hotMovie) {
		this.hotMovie = hotMovie;
	}

	@Column(name = "now_showing", nullable = false)
	public boolean isNowShowing() {
		return this.nowShowing;
	}

	public void setNowShowing(boolean nowShowing) {
		this.nowShowing = nowShowing;
	}

	@Column(name = "coming_soon", nullable = false)
	public boolean isComingSoon() {
		return this.comingSoon;
	}

	public void setComingSoon(boolean comingSoon) {
		this.comingSoon = comingSoon;
	}

	@Column(name = "length", nullable = false)
	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date", nullable = false, length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
	public Set<Movieshowtime> getMovieshowtimes() {
		return this.movieshowtimes;
	}

	public void setMovieshowtimes(Set<Movieshowtime> movieshowtimes) {
		this.movieshowtimes = movieshowtimes;
	}

}
