package com.sloteazy.app.dao;

import com.sloteazy.app.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to define methods explicitly for basic CRUD operations as JPA Handles this
    @Query("SELECT u.userId FROM User u WHERE u.email = :email")
    Long findUserIdByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("Delete from User u where u.email=:email")
    void deleteUserByEmail(@Param("email") String email);
}