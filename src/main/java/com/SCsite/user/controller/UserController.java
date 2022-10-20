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
    public String Signup(@RequestParam("UserID") String userID, @RequestParam("Name") String name, @RequestParam("Password") String password1, @RequestParam("Password") String password2, @RequestParam("Gender") String gender) {
        if (password1 == password2){
            this.sluserService.save(userID,name,password1,gender);
            return "회원가입 축하합니다.";
        }else {
            return "비밀번호를 확인해주세요.";
        }
    }

    @PostMapping("/Login")
    @ResponseBody
    public String Login(@RequestParam("UserID") String userID, @RequestParam("Password") String password) throws Exception {
        this.sluserService.findByUserID(userID);
        return userID;
    }
}
