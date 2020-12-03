package com.scriptkiddie.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scriptkiddie.cmsshoppingcart.models.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    
}