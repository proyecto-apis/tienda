package com.scriptkiddie.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scriptkiddie.cmsshoppingcart.models.data.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);
}