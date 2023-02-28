package com.insy2s.ServiceUser.repository;

import com.insy2s.ServiceUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 ")
    Optional<User> findUserByEmail(String  email);
}
