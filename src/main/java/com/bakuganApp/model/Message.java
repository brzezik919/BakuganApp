package com.bakuganApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_writer")
    private User userWriter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reader")
    private User userReader;

    private LocalDateTime time;

    public Message(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserWriter() {
        return userWriter;
    }

    public void setUserWriter(User userWriter) {
        this.userWriter = userWriter;
    }

    public User getUserReader() {
        return userReader;
    }

    public void setUserReader(User userReader) {
        this.userReader = userReader;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
