package com.SCsite.user.coinboard.service;

import com.SCsite.user.coinboard.dao.CoinRepository;
import com.SCsite.user.coinboard.domain.Coin;
import com.SCsite.user.coinboard.dto.CoinListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService {
    private final CoinRepository coinRepository;

    public void save(String title, String content, String writer) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow = now.format(formatter);

        Coin C1 = new Coin();
        C1.setTitle(title);
        C1.setContent(content);
        C1.setWriter(writer);
        C1.setViews(0);
        C1.setDate(formatedNow);
        this.coinRepository.save(C1);
    }

    public CoinListDto findAll() {
        List<Coin> coin = coinRepository.findAll();
        CoinListDto coinListDto = new CoinListDto();
        coinListDto.setTitle(coinListDto.getTitle());
        coinListDto.setWriter(coinListDto.getWriter());
        coinListDto.setDate(coinListDto.getDate());
        coinListDto.setViews(coinListDto.getViews());
        return coinListDto;
    }
}
