package com.animalprovider.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String species;
	private String breed;
	private String colour;
	private String gender;
	private boolean vaccinated;
	
	
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(int id, String species, String breed, String colour, String gender, boolean vaccinationStatus) {
		super();
		this.id = id;
		this.species = species;
		this.breed = breed;
		this.colour = colour;
		this.gender = gender;
		vaccinated = vaccinationStatus;
	}

	public int getId() {
		return id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinationStatus(boolean vaccinationStatus) {
		vaccinated = vaccinationStatus;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", species=" + species + ", breed=" + breed + ", colour=" + colour + ", gender="
				+ gender + ", vaccinated=" + vaccinated + "]";
	}

	@Override
	public Pet clone() throws CloneNotSupportedException {
		Pet cloneObj = new Pet();

		cloneObj.breed = this.breed;
		cloneObj.colour = this.colour;
		cloneObj.gender = this.gender;
		cloneObj.id = this.id;
		cloneObj.species = this.species;
		cloneObj.vaccinated = this.vaccinated;

		return cloneObj;
	}

}
