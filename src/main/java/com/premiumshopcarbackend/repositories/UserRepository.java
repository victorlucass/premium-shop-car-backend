package com.premiumshopcarbackend.repositories;

import com.premiumshopcarbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   @Transactional(readOnly = true)
    User findByEmail(String email );
}
