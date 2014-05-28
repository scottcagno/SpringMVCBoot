package com.cagnosolutions.cei.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cagnosolutions.cei.spring.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	//@Query("SELECT COUNT(u.username) FROM Users u WHERE LOWER(u.username)=LOWER(:username)")
	//public int userExists(@Param("username")String username);
	
	@Query("SELECT a FROM Account a WHERE LOWER(a.user.username)=LOWER(:username)")
	public Account findByUsername(@Param("username") String username);
}
