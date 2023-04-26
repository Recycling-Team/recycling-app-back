package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FatReservation extends Reservation {
    

    private Item item;



    public FatReservation() {
    }

    public FatReservation(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
