package com.SCsite.user.coinboard.controller;

import com.SCsite.user.coinboard.dto.CoinListDto;
import com.SCsite.user.coinboard.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public CoinListDto get() {return this.coinService.findAll();}
}
