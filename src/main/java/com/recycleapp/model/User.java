package com.recycleapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity



public class User {
    @Id
    @OneToMany
    @JsonIgnoreProperties("")
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String name;

    public User(Reservation reservation) {
        super();
		this.reservation = reservation;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(Reservation reservation, String name) {
        this.reservation = reservation;
        this.name = name;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public User reservation(Reservation reservation) {
        setReservation(reservation);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " reservation='" + getReservation() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

  
}