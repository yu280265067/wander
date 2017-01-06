package com.ycx.model;

import java.util.Date;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private int id;
	private int[] ids;
	private String name;
	private String telephone;
	private String email;
	
	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date birth;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telephone=" + telephone + ", email=" + email + ", birth="
				+ birth + "]";
	}

	public User(int id, String name, String telephone, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.birth = birth;
	}

	public User(){
		
	}
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
