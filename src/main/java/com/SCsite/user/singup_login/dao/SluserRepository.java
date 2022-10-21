package com.SCsite.user.singup_login.dao;

import com.SCsite.user.singup_login.domain.Sluser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SluserRepository extends JpaRepository<Sluser, Long> {
    Sluser findByUserID(String userID);
}
