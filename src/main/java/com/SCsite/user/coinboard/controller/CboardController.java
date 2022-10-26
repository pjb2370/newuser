package com.SCsite.user.coinboard.controller;

import com.SCsite.user.coinboard.domain.Coin;
import com.SCsite.user.coinboard.dto.CoinListDto;
import com.SCsite.user.coinboard.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class CboardController {
    private final CoinService coinService;

    @PostMapping("/boardup")
    @ResponseBody
    public String post (@RequestParam("Title") String title, @RequestParam("Content") String content, @RequestParam("Writer") String writer){
        this.coinService.save(title, content, writer);
        return "저장이 완료되었습니다.";
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Coin> get() {return this.coinService.findAll();}

    @GetMapping("/get/{id}")
    @ResponseBody
    public Coin getContents(@PathVariable("id") Integer id){
        return this.coinService.findById(id);
    }

    @PatchMapping("/patch/{id}")
    @ResponseBody
    public String PatchContents(@PathVariable("id") Integer id, @RequestParam("Title") String title, @RequestParam("Content") String content, @RequestParam("Writer") String writer){
        return this.coinService.findByIdToPatch(id,title,content,writer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String DeleteContents(@PathVariable("id") Integer id) {
        return this.coinService.findByIdToDelte(id);
    }
}

