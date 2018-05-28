package com.mkyong.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RepoFactory {
	
	@Autowired
	ClassRepository cRepo;
	
	@Autowired
	ClubRepository clRepo;
	
	@Autowired
	GroupRepository gRepo;
	
	@Autowired
	ProfessorRepository pRepo;
	
	@Autowired
	RoomRepository rRepo;
	
	@Autowired
	StudentRepository sRepo;

	public CrudRepository<?,?> getRepository(String type)
	{
		System.out.println(type + "repo now");
		if (type.equals("class"))
			return cRepo;
		else if (type.equals("club"))
			return clRepo;
		else if (type.equals("group"))
			return gRepo;
		else if (type.equals("prof"))
			return pRepo;
		else if (type.equals("room"))
			return rRepo;
		else if (type.equals("student"))
			return sRepo;
		else
			throw new IllegalArgumentException("Invalid type");
	}
		
}
