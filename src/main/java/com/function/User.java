package com.function;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    
    private String username;
    private String email;

    @JoinColumn(name = "item_id")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setUser(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setUser(null);
    }

    public List<Item> getItems() {
        return items;
    }
}