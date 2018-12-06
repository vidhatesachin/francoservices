package com.franco.app.dataobjects;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Branch {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	private String branchcode;
	private String branchname;
	private String email;
	private String password;
	private String phonenumber;
	private String branchadress;
	private Character status;
	
	/**
	 * 
	 */
	public Branch() {
		super();
	}
	/**
	 * @param id
	 */
	public Branch(long id) {
		super();
		this.id = id;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBranchcode() {
		return branchcode;
	}
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBranchadress() {
		return branchadress;
	}
	public void setBranchadress(String branchadress) {
		this.branchadress = branchadress;
	}

	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	
	}
