package com.SCsite.user.coinboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String title;
    private String content;
    @Column(length = 20)
    private String writer;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private String date;
    private Integer views;
}
