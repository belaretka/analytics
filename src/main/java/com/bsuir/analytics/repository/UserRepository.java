package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByUsername(String name);
    User findUserById(long id);

}