package com.mkyong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRoom")
	public int idRoom;
	
	@Column(name="name")
	public String name;
	
	@Column(name="addr")
	public String addr;
	
	
	public Room (){}

	public Room(String name, String addr) {
		super();
		this.name = name;
		this.addr = addr;
	}



	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
}
