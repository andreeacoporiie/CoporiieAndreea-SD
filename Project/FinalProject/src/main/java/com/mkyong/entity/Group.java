package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_table")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idGroup")
	public int idGroup;
	
	@Column(name="year")
	public int year;
	
	@Column(name="faculty")
	public String faculty;
	
	public Group (){}
	
	public Group(int year, String faculty) {
		super();
		this.year = year;
		this.faculty = faculty;
	}



	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Group [idGroup=" + idGroup + ", year=" + year + ", faculty=" + faculty + "]";
	}
	
	
}
