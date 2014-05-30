//package com.cagnosolutions.cei.spring.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.cagnosolutions.cei.spring.data.UserRepository;
//import com.cagnosolutions.cei.spring.domain.User;
//
//
//@Transactional
//@Service("usersService")
//public class UsersService {
//
//	@Autowired
//	private UsersRepository dao;
//	
//	public void insert(Users users){
//		dao.save(users);
//	}
//
//	public void update(Users users){
//		dao.save(users);
//	}
//
//	public void delete(Users users){
//		dao.delete(users);
//	}
//
//	public List<Users> findAll(){
//		return dao.findAll();
//	}
//
//	public Users findById(String id){
//		return dao.findOne(id);
//	}
//}
