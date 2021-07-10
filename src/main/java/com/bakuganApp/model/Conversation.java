package com.bakuganApp.model;

import javax.persistence.*;

@Entity
@Table(name="chats")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_first_user")
    private User firstUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_second_user")
    private User secondUser;

    public Conversation(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }
}
