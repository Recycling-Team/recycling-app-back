package com.recycleapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    

    @OneToMany
    @JsonIgnoreProperties("")
    @JoinColumn(name = "user_id")
    private List<Reservation> reservation;

    private String user_name;

    public User() {
        
    }

    public User(Long user_id, List<Reservation> reservation, String user_name) {
        this.reservation = reservation;
        this.user_name = user_name;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Reservation> getReservation() {
        return this.reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", reservation='" + getReservation() + "'" +
            ", user_name='" + getUser_name() + "'" +
            "}";
    }
  
}