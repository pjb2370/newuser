package com.SCsite.user.coinboard.dao;

import com.SCsite.user.coinboard.domain.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Integer> {
    Coin findByTitle(String title);
}
