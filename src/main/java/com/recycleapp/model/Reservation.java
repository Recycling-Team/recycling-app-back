package com.recycleapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reservation {
    
    @Id
    private Long reservation_id;

	@OneToOne(optional=false)
	@JsonIgnoreProperties("reservation")
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(optional=false)
	@JsonIgnoreProperties("reservations")
	@JoinColumn(name = "user_id")
	private Usera user;

	private String date;

	public Reservation(Item item, Usera user, String date) {
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

	public Usera getUser() {
		return user;
	}

	public void setUser(Usera user) {
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
