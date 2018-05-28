package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClass")
	public int idClass;
	
	@Column(name="time")
	public int time;
	
	@Column(name="day")
	public String day;
	
	@ManyToOne
	@JoinColumn(name = "grpid")
	public Group group;
	
	@ManyToOne
	@JoinColumn(name = "profid")
	public Professor prof;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	public Room room;

	
	public Class (){}

	public Class(int time, String day, Group group, Professor prof, Room room) {
		super();
		this.time = time;
		this.day = day;
		this.group = group;
		this.prof = prof;
		this.room = room;
	}



	public int getIdClass() {
		return idClass;
	}


	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public Professor getProf() {
		return prof;
	}


	public void setProf(Professor prof) {
		this.prof = prof;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return prof.getSubject() + " Class " + " |  Prof." + prof.getUsername() 
				+ "\n Room " + room.getName();
	}
	
	public boolean isMonday(){
		if (this.day.equals("mon"))
			return true;
		return false;
	}
	
	public boolean isTuesday(){
		if (this.day.equals("tue"))
			return true;
		return false;
	}
	
	public boolean isWednesday(){
		if (this.day.equals("wed"))
			return true;
		return false;
	}
	
	public boolean isThursday(){
		if (this.day.equals("thu"))
			return true;
		return false;
	}
	
	public boolean isFriday(){
		if (this.day.equals("fri"))
			return true;
		return false;
	}
	
	
	
	
	public boolean is9(){
		if (this.time == 9)
			return true;
		return false;
	}
	
	public boolean is12(){
		if (this.time == 12)
			return true;
		return false;
	}
	
	public boolean is15(){
		if (this.time == 15)
			return true;
		return false;
	}
	
	public boolean is18(){
		if (this.time == 18)
			return true;
		return false;
	}
	
	
	
	
}
