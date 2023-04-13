package com.animalprovider.dao;

import org.springframework.data.repository.CrudRepository;

import com.animalprovider.entities.Pet;

public interface PetRepository extends CrudRepository<Pet,Integer>{
	
	
	
}
