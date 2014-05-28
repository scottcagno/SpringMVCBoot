package com.cagnosolutions.cei.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cagnosolutions.cei.spring.data.AccountRepository;
import com.cagnosolutions.cei.spring.domain.Account;

@Transactional
@Service("accountService")
public class AccountService {
	
	@Autowired
	private AccountRepository dao;

	public void insert(Account account) {
		dao.save(account);
	}

	public void update(Account account) {
		dao.save(account);
	}

	public void delete(Account account) {
		dao.delete(account);
	}

	public List<Account> findAll() {
		return dao.findAll();
	}

	public Account findById(Long id) {
		return dao.findOne(id);
	}
	
	public Account findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
//	public boolean userExists(String username) {
//		return (dao.userExists(username) > 0) ? true : false;
//	}
}
