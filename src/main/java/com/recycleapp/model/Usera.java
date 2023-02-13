package com.recycleapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usera {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation_id")
    @JsonIgnoreProperties("user")
    private List<Reservation> reservations;

    private String user_name;

    public Usera() {

    }

    public Usera(String user_name) {
        this.user_name = user_name;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Reservation> getReservation() {
        return this.reservations;
    }

    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
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