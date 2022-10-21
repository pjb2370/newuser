package com.SCsite.user.coinboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String
}
