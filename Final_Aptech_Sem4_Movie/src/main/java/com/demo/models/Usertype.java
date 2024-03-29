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
 * Usertype generated by hbm2java
 */
@Entity
@Table(name = "usertype", catalog = "aptechmovies")
public class Usertype implements java.io.Serializable {

	private Integer id;
	private String name;
	private boolean status;
	private Set<Account> accounts = new HashSet<Account>(0);

	public Usertype() {
	}

	public Usertype(String name, boolean status) {
		this.name = name;
		this.status = status;
	}

	public Usertype(String name, boolean status, Set<Account> accounts) {
		this.name = name;
		this.status = status;
		this.accounts = accounts;
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

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usertype")
	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
