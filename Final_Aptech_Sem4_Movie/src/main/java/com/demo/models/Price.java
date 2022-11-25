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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Price generated by hbm2java
 */
@Entity
@Table(name = "price", catalog = "aptechmovies")
public class Price implements java.io.Serializable {

	private Long id;
	private double price;
	private String description;
	private boolean status;
	private Set<TicketPriceDetail> ticketPriceDetails = new HashSet<TicketPriceDetail>(0);

	public Price() {
	}

	public Price(double price, String description, boolean status) {
		this.price = price;
		this.description = description;
		this.status = status;
	}

	public Price(double price, String description, boolean status, Set<TicketPriceDetail> ticketPriceDetails) {
		this.price = price;
		this.description = description;
		this.status = status;
		this.ticketPriceDetails = ticketPriceDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "price")
	public Set<TicketPriceDetail> getTicketPriceDetails() {
		return this.ticketPriceDetails;
	}

	public void setTicketPriceDetails(Set<TicketPriceDetail> ticketPriceDetails) {
		this.ticketPriceDetails = ticketPriceDetails;
	}

}
