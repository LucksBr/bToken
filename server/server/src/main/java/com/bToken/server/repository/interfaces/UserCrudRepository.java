package com.bToken.server.repository.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bToken.server.model.User;

@Repository
public interface UserCrudRepository extends JpaRepository<User,Integer> {
    
    @Query("SELECT * FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}
