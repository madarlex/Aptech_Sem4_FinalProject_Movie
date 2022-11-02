package com.demo.models;
// Generated Nov 2, 2022, 8:26:37 PM by Hibernate Tools 4.3.6.Final

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

/**
 * Ticket generated by hbm2java
 */
@Entity
@Table(name = "ticket", catalog = "aptechmovies")
public class Ticket implements java.io.Serializable {

	private Integer id;
	private Account account;
	private Hall hall;
	private Movieshowtime movieshowtime;
	private Seat seat;
	private boolean status;
	private Set<TicketPriceDetail> ticketPriceDetails = new HashSet<TicketPriceDetail>(0);

	public Ticket() {
	}

	public Ticket(Account account, Hall hall, Movieshowtime movieshowtime, Seat seat, boolean status) {
		this.account = account;
		this.hall = hall;
		this.movieshowtime = movieshowtime;
		this.seat = seat;
		this.status = status;
	}

	public Ticket(Account account, Hall hall, Movieshowtime movieshowtime, Seat seat, boolean status,
			Set<TicketPriceDetail> ticketPriceDetails) {
		this.account = account;
		this.hall = hall;
		this.movieshowtime = movieshowtime;
		this.seat = seat;
		this.status = status;
		this.ticketPriceDetails = ticketPriceDetails;
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
	@JoinColumn(name = "user_id", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
	@JoinColumn(name = "movie_show_time_id", nullable = false)
	public Movieshowtime getMovieshowtime() {
		return this.movieshowtime;
	}

	public void setMovieshowtime(Movieshowtime movieshowtime) {
		this.movieshowtime = movieshowtime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seat_id", nullable = false)
	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
	public Set<TicketPriceDetail> getTicketPriceDetails() {
		return this.ticketPriceDetails;
	}

	public void setTicketPriceDetails(Set<TicketPriceDetail> ticketPriceDetails) {
		this.ticketPriceDetails = ticketPriceDetails;
	}

}
