package com.SCsite.user.controller;

import com.SCsite.user.dao.SluserRepository;
import com.SCsite.user.domain.Sluser;
import com.SCsite.user.service.SluserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final SluserService sluserService;

    @PostMapping("/SignUp")
    @ResponseBody
    public String Signup(@RequestParam("UserID") String userID, @RequestParam("Name") String name, @RequestParam("Password") String password, @RequestParam("Gender") String gender) {
        this.sluserService.save(userID, name, password, gender);
        return "회원가입 축하합니다.";
    }

    @PostMapping("/Login")
    @ResponseBody
    public String Login(@RequestParam("UserID") String userID, @RequestParam("Password") String password) throws Exception {
        this.sluserService.findByUserID(userID);
        return userID;
    }
}
