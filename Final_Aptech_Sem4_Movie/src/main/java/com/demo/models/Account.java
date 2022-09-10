package com.demo.models;
// Generated Sep 10, 2022, 9:42:19 PM by Hibernate Tools 4.3.6.Final

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
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "aptechmovies")
public class Account implements java.io.Serializable {

	private Integer id;
	private Usertype usertype;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String fullName;
	private boolean status;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Account() {
	}

	public Account(Usertype usertype, String username, String password, String email, String phone, String fullName,
			boolean status) {
		this.usertype = usertype;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.fullName = fullName;
		this.status = status;
	}

	public Account(Usertype usertype, String username, String password, String email, String phone, String fullName,
			boolean status, Set<Ticket> tickets) {
		this.usertype = usertype;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.fullName = fullName;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type", nullable = false)
	public Usertype getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	@Column(name = "username", nullable = false, length = 250)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 250)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false, length = 250)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "full_name", nullable = false, length = 250)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
