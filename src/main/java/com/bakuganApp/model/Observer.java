package com.bakuganApp.model;

import javax.persistence.*;

@Entity
@Table(name = "observers")
public class Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_auction")
    private Auction auction;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User userWatcher;
    private boolean stillWatch;

    public Observer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getUserWatcher() {
        return userWatcher;
    }

    public void setUserWatcher(User userWatcher) {
        this.userWatcher = userWatcher;
    }

    public boolean isStillWatch() {
        return stillWatch;
    }

    public void setStillWatch(boolean stillWatch) {
        this.stillWatch = stillWatch;
    }
}
