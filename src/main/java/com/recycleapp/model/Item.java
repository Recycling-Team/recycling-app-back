package com.recycleapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Item {
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @OneToOne
    @JsonIgnoreProperties("item")
	@JoinColumn(name = "item_id")
    private Reservation reservation;

    private String item_name;

    public Item() {
    }

    public Item(String item_name) {
        this.item_name = item_name;
    }


    public Long getItem_id() {
        return this.item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getItem_name() {
        return this.item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    


    @Override
    public String toString() {
        return "{" +
            " item_id='" + getItem_id() + "'" +
            ", reservation='" + getReservation() + "'" +
            ", item_name='" + getItem_name() + "'" +
            "}";
    }

}
