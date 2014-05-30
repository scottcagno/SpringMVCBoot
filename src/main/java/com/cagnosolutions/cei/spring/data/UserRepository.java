package com.cagnosolutions.cei.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cagnosolutions.cei.spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
