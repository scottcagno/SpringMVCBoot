package com.cagnosolutions.cei.spring.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	private String username;
	private String password;
	private short enabled;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="groups_id")
	private Groups groups;
	
	public Users() {}
	
	public Users(String username, String password, short enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = 1;
		this.groups = new Groups(username, "ROLE_USER");
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

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public short getEnabled() {
		return enabled;
	}	
}