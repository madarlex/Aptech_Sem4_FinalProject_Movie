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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Movieshowtime generated by hbm2java
 */
@Entity
@Table(name = "movieshowtime", catalog = "aptechmovies")
public class Movieshowtime implements java.io.Serializable {

	private Integer id;
	private Hall hall;
	private Movie movie;
	private Date showDate;
	private boolean status;
	private Date showTime;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Movieshowtime() {
	}

	public Movieshowtime(Hall hall, Movie movie, Date showDate, boolean status, Date showTime) {
		this.hall = hall;
		this.movie = movie;
		this.showDate = showDate;
		this.status = status;
		this.showTime = showTime;
	}

	public Movieshowtime(Hall hall, Movie movie, Date showDate, boolean status, Date showTime, Set<Ticket> tickets) {
		this.hall = hall;
		this.movie = movie;
		this.showDate = showDate;
		this.status = status;
		this.showTime = showTime;
		this.tickets = tickets;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hall_id", nullable = false)
	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id", nullable = false)
	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "show_date", nullable = false, length = 10)
	public Date getShowDate() {
		return this.showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "show_time", nullable = false, length = 8)
	public Date getShowTime() {
		return this.showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movieshowtime")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
