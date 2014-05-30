//package com.cagnosolutions.cei.spring.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.cagnosolutions.cei.spring.data.GroupsRepository;
//import com.cagnosolutions.cei.spring.domain.Groups;
//
//@Transactional
//@Service("groupsService")
//public class GroupsService {
//
//	@Autowired
//	private GroupsRepository dao;
//	
//	public void insert(Groups groups){
//		dao.save(groups);
//	}
//
//	public void update(Groups groups){
//		dao.save(groups);
//	}
//
//	public void delete(Groups groups){
//		dao.delete(groups);
//	}
//
//	public List<Groups> findAll(){
//		return dao.findAll();
//	}
//
//	public Groups findById(String id){
//		return dao.findOne(id);
//	}
//}
