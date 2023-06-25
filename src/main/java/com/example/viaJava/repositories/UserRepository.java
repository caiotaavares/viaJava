package com.example.viaJava.repositories;

import com.example.viaJava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameAndPassword(String name, String password);
}
