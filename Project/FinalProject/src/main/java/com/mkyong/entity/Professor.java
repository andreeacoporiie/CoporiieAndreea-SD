package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idProfessor;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	public String password;
	
	@Column(name="subject")
	public String subject;
	
	@Column(name="rank")
	public int rank;
 
	@Column(name="isAdmin")
	int isAdmin;
	
	
	public Professor (){}
	
	public Professor(String username, String password, String subject, int rank, int isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.subject = subject;
		this.rank = rank;
		this.isAdmin = isAdmin;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isAdmin() {
		return (this.isAdmin == 1);
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", username=" + username + ", password=" + password
				+ ", subject=" + subject + ", rank=" + rank + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}
