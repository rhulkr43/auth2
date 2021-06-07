package com.auth2.auth2.Repository;

import javax.transaction.Transactional;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth2.auth2.entity.User;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

	@Query(name = "select u from users u where u.username = :username", nativeQuery=true)
	User findByUsername(@Param("username") String username); 
}
