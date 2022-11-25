package com.demo.models;

public class addedPrice {
	private String id;
	private String price;
	private String description;
	public addedPrice(String id, String price, String description) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
	}
	public addedPrice() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
