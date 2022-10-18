package com.SCsite.user.dao;

import com.SCsite.user.domain.Sluser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SluserRepository extends JpaRepository <Sluser, Long> {

    void findByUserID(String userID);
}
