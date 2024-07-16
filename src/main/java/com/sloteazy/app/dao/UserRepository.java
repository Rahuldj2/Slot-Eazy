package com.sloteazy.app.dao;

import com.sloteazy.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to define methods explicitly for basic CRUD operations as JPA Handles this
}