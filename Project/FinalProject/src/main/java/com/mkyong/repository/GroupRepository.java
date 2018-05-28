package com.mkyong.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {

}
