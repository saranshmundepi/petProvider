package com.animalprovider.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animalprovider.entities.Pet;
import com.animalprovider.services.PetService;

@RestController
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping("/getListOfAllPets")
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}

	@GetMapping("/getPet/{id}")
	public Pet getPetById(@PathVariable Integer id) {
		return petService.getPetById(id);
	}

	@PostMapping("/addPet")
	public String savePet(@RequestBody Pet pet) {
		if (petService.savePet(pet))
			return pet.toString() + " Added";
		return pet.toString() + " NOT Added";
	}

	@PostMapping("/addListOfPets")
	public String saveListOfPet(@RequestBody List<Pet> listOfPets) {
		String response = null;
		for (Pet pet : listOfPets)
			response = response + "\n" + savePet(pet);
		return response;
	}

	@DeleteMapping("/deletePet/{id}")
	public String deletePet(@PathVariable Integer id) throws CloneNotSupportedException {
		Pet x = getPetById(id);
		if (Objects.isNull(x))
			return "No such pet present";

		Pet petClone = x.clone();
		petService.deletePet(id);

		x = getPetById(id);
		if (Objects.isNull(x))
			return petClone.toString() + " Deleted";

		return petClone.toString() + "Can't not be deleted ";
	}
}