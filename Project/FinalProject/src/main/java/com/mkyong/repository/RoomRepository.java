package com.mkyong.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {

}
