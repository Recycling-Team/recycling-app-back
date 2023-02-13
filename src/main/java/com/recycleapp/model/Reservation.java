package com.recycleapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reservation {
    
	@Id
	@OneToOne(optional=false)
	@JsonIgnoreProperties("reservation")
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Id
	@OneToOne(optional=false)
	@JsonIgnoreProperties("reservations")
	@JoinColumn(name = "user_id")
	private User user;

	private String date;

	public Reservation(Item item, User user, String date) {
		super();
		this.item = item;
		this.user = user;
		this.date = date;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reservation [item=" + item + ", user=" + user + ", date=" + date + "]";
	}
	
	
	
}
