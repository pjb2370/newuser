package com.SCsite.user.service;

import com.SCsite.user.dao.SluserRepository;
import com.SCsite.user.domain.Sluser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SluserService {
    private final SluserRepository sluserRepository;

    public void save(String userID, String name, String password, String gender) {
        Sluser S1 = new Sluser();
        S1.setUserID(userID);
        S1.setName(name);
        S1.setPassword(password);
        S1.setGender(gender);
        this.sluserRepository.save(S1);
    }

    public String Login(String userID, String password) {
        Optional<Sluser> opSluser = Optional.ofNullable(SluserRepository);
    }
}
