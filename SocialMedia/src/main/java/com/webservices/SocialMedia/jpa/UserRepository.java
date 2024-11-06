package com.webservices.SocialMedia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.SocialMedia.User.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
