package com.mkyong.repository;

import org.springframework.data.repository.CrudRepository;

import com.mkyong.entity.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

}
