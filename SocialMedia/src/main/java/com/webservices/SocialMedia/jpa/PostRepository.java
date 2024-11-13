package com.webservices.SocialMedia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.SocialMedia.User.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{

}
