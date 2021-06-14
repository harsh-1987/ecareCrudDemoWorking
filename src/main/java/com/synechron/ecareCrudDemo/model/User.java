package com.synechron.ecareCrudDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	

	public User() {
		super();
	}

	public User(long id, String name, String occupation) {
		super();
		this.id = id;
		this.name = name;
		this.occupation = occupation;
	}
	
	@Id
	private long id ; 
	
	@Column
	private String name ; 
	
	@Column
	private String occupation;

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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
