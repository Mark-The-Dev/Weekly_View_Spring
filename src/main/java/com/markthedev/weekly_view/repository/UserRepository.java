package com.markthedev.weekly_view.repository;

import com.markthedev.weekly_view.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //Optional<User> findByEmail(String email);
}

