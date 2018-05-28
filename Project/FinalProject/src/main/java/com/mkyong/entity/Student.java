package com.mkyong.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStudent")
	public int idStudent;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	public String password;
	
	@ManyToOne
	@JoinColumn(name = "groupid")
	public Group group;
	
	@ManyToMany
	@JoinTable( name = "enrollment",
    joinColumns = {@JoinColumn(name = "studentid")},
    inverseJoinColumns = {@JoinColumn(name = "clubname")})
	public List<Club> clubs;	

	
	public Student (){}

	public Student(String username, String password, Group group) {
		super();
		this.username = username;
		this.password = password;
		this.group = group;
	}



	public int getIdStudent() {
		return idStudent;
	}


	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", username=" + username + ", password=" + password + ", group="
				+ group + "]";
	}
	
	
}
