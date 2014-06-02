package com.cagnosolutions.cei.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cagnosolutions.cei.spring.data.UserRepository;
import com.cagnosolutions.cei.spring.domain.User;

@Transactional
@Service("usersService")
public class UserService {

	@Autowired
	private UserRepository dao;
	
	public User insert(User user){
		return dao.saveAndFlush(user);
	}

	public void update(User user){
		dao.save(user);
	}

	public void delete(User user){
		dao.delete(user);
	}

	public List<User> findAll(){
		return dao.findAll();
	}

	public User findById(Long id){
		return dao.findOne(id);
	}
	
	public boolean exists(String username) {
		return dao.exists(username) > 0;
	}
}
