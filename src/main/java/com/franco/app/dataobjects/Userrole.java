package com.franco.app.dataobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userrole {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String role;
	private String description;
	private Character status;
    
	/**
	 * 
	 */
	public Userrole() {
		super();
	}
	/**
	 * @param id
	 */
	public Userrole(long id) {
		super();
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	 
	
}
