package com.function;

import java.util.List;
import javax.persistence.*;

@Entity
public class Item {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Item() {
    }

    public Item(String itemName, User user) {
        this.user = user;
    }

    public int getItemId() {
        return itemId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}