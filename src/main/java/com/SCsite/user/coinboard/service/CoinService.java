package com.SCsite.user.coinboard.service;

import com.SCsite.user.coinboard.dao.CoinRepository;
import com.SCsite.user.coinboard.domain.Coin;
import com.SCsite.user.coinboard.dto.CoinListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

    public List<Coin> findAll() {
        List<Coin> coin = coinRepository.findAll();

        return coin;
    }

    public Coin findById(Integer id) {
        Optional<Coin> coinOptional = coinRepository.findById(id);
        Coin coin = coinOptional.get();
        return coin;
    }

    public Coin findByTitle(String title) {
        return coinRepository.findByTitle(title);
    }

    public String findByIdToPatch(Integer id, String title, String content, String writer) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow = now.format(formatter);

        Optional<Coin> optionalCoin = coinRepository.findById(id);
        if (optionalCoin.isPresent()) {
            Coin coin = optionalCoin.get();
            coin.setTitle(title);
            coin.setContent(content);
            coin.setWriter(writer);
            coin.setDate(formatedNow);
            coinRepository.save(coin);
            System.out.println("저장성공");;
            return id + "번 게시판의 수정이 완료되었습니다.";
        }
        else {
            System.out.println("저장실패");
            return id + "번 게시판의 저장실패";
        }
    }

    public String findByIdToDelte(Integer id) {
        this.coinRepository.deleteById(id);
        return id + "번 게시판의 삭제가 완료되었습니다.";
    }
}
