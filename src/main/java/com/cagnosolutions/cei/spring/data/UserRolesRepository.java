package com.cagnosolutions.cei.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cagnosolutions.cei.spring.domain.User;
import com.cagnosolutions.cei.spring.domain.Users;

@Repository
@Transactional
public interface UserRolesRepository extends JpaRepository<Users,String> {
}