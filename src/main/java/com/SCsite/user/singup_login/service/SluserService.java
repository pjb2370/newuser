package com.SCsite.user.singup_login.service;

import com.SCsite.user.singup_login.dao.SluserRepository;
import com.SCsite.user.singup_login.domain.Sluser;
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

    public boolean Login(String userID, String password) {
//         input id, pw
//         id == 있음면? id가 포함된 데이터를 통채로 가져옴.
//         id 없으면? == NULL null이 들어오면 에러가나요.
//         데이터를 가져온뒤 해야하는일
//         입력받은 패스워드(유저가 입력한 패스워드) '와'
//         데이터베이스에 입력되어있는 패스워드 '가'
//         '같은지를 비교'
        Optional<Sluser> opSluser = Optional.ofNullable(sluserRepository.findByUserID(userID));
        if (opSluser.isPresent()){
            Sluser sluser = sluserRepository.findByUserID(userID);
            if (sluser.getPassword().equals(password)) {
                return true;
            }
//            원시데이터타입 = 데이터량이 적음 = 값을 직접 호출해서 비교함.
//                    배열, 객체같은 '원시 데이터 타입이 아닌애들' 은 데이터량이 너무큼. 그래서 '실제 값'이 아닌 '주소값'을 가지고다님.
//            그래서 두 객체나, 배열안의 실제 데이터는 같아도, 주소는 항상다르기때문에 언제나 false가 나옴.
            else {
                return false;
            }
        } else{
            return false;
        }
    }




}
