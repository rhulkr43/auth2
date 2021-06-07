package com.auth2.auth2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth2.auth2.entity.Post;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long>{

}
