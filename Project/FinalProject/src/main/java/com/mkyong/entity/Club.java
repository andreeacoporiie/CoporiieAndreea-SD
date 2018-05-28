package com.mkyong.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="club")
public class Club {
	
	@Id
	@Column(name="nameClub")
	String name;
	
	@Column(name="description")
	String description;

	@ManyToMany(mappedBy = "clubs")
    private List<Student> enrolledStudents;
	
	public Club (){}
	
	public Club(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Club [name=" + name + ", description=" + description + "]";
	}
	
	

}