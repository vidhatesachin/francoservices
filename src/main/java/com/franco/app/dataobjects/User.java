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
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String name;
	private String email;
	private String password;
	private String phonenumber;
	@JsonIgnore
    private Date createdDateTime=new Date();
	private String imageIds;
	@ManyToOne
   	@JoinColumn(name = "roleId")
	private Userrole userrole;
	private Character status;
    
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param id
	 */
	public User(long id) {
		super();
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
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
	public String getImageIds() {
		return imageIds;
	}
	public void setImageIds(String imageIds) {
		this.imageIds = imageIds;
	}
	public Userrole getUserrole() {
		return userrole;
	}
	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	
	 
	 
}
