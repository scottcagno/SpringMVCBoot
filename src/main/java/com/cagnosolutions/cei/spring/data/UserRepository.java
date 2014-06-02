package com.cagnosolutions.cei.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cagnosolutions.cei.spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	@Query("SELECT COUNT(u) FROM User u WHERE LOWER(u.username)=LOWER(:username)")
	public int exists(@Param("username") String username);
}
