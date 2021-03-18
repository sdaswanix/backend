package com.example.demo.domain.Comment;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Comment {
    @Id
    @Type(type = "uuid-char")
    public UUID id;

    @Column(nullable = false)
    public String text;

    private Date date;

    @Column(nullable = false)
    public Date getDate() {
        return this.date;
    }

    public void SetDate(Date value) {
        this.date = value;
    }

    @Column(nullable = false)
    public Integer rating;
}
