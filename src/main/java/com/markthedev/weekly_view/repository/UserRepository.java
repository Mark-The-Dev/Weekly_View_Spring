package com.markthedev.weekly_view.repository;


import com.markthedev.weekly_view.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameEmail(String email);


}

