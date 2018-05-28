package com.mkyong.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.entity.Class;

public interface ClassRepository extends CrudRepository<Class, Integer> {

}
