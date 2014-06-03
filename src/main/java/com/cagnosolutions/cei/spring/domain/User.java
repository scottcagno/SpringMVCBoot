package com.cagnosolutions.cei.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String username;
	private String name;
	private String email;
	private String password;
	private short enabled;
	@Column(name="userGroup")
	private String userGroup;
	
	public User() {}
	
	public User(String username, String password, short enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = 1;
		this.userGroup = "ROLE_USER";
	}
	
	public User(String username, String password, short enabled, String userGroup) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userGroup = userGroup;
	}
	
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short isEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public short getEnabled() {
		return enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}	
}