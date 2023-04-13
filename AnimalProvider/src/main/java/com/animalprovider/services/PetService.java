package com.animalprovider.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animalprovider.dao.PetRepository;
import com.animalprovider.entities.Pet;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;
    
    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }
    
    public Pet getPetById(Integer id) {
        return petRepository.findById(id).orElse(null);
    }
    
    public boolean savePet(Pet pet) {
        Pet x = petRepository.save(pet);
        if(Objects.isNull(x))
        	return false;
        return true;
    }
    
    public void deletePet(Integer id) {
        petRepository.deleteById(id);
    }
}