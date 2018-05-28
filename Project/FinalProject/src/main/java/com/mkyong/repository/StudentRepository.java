package com.mkyong.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.entity.Student;

public interface StudentRepository extends CrudRepository< Student, Integer>{ 

}
