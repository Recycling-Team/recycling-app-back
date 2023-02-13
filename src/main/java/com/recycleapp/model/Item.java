package com.recycleapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Item {

    @Id
    @OneToOne
    @JsonIgnoreProperties("")
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getItem() {
        return name;
    }

    public void setItem(String name) {
        this.name = name;
    }

    private String getName() {
        return null;
    }

    private String getReservation() {
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                " reservation='" + getReservation() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
