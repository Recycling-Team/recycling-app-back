package com.common;

public class Rating {
    
    private int rating_id;

    private String rating;

    private int user;

    public Rating() {
    }


    public Rating(int rating_id, String rating, int user) {
        this.rating_id = rating_id;
        this.rating = rating;
        this.user = user;
    }



    public int getRating_id() {
        return this.rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getUser() {
        return this.user;
    }

    public void setUser(int user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "{" +
            " rating_id='" + getRating_id() + "'" +
            ", rating='" + getRating() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }


}

