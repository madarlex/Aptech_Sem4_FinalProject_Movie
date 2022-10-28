package com.demo.models;
// Generated Oct 21, 2022, 10:29:21 PM by Hibernate Tools 4.3.6.Final

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

/**
 * Hall generated by hbm2java
 */
@Entity
@Table(name = "hall", catalog = "aptechmovies")
public class Hall implements java.io.Serializable {

	private Integer id;
	private String name;
	private int seatNumbers;
	private boolean status;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Hall() {
	}

	public Hall(String name, int seatNumbers, boolean status) {
		this.name = name;
		this.seatNumbers = seatNumbers;
		this.status = status;
	}

	public Hall(String name, int seatNumbers, boolean status, Set<Ticket> tickets) {
		this.name = name;
		this.seatNumbers = seatNumbers;
		this.status = status;
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

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "seat_numbers", nullable = false)
	public int getSeatNumbers() {
		return this.seatNumbers;
	}

	public void setSeatNumbers(int seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
