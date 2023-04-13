package com.animalprovider.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Shop implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String owner;
	private String street;
	private String landmark;
	private String city;
	private String district;
	private String state;

	@OneToMany(cascade=CascadeType.ALL)
	private Set<Pet> pets=new HashSet<>();
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(int id, String name, String owner, String street, String landmark, String city, String district,
			String state) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
		
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", owner=" + owner + ", street=" + street + ", landmark="
				+ landmark + ", city=" + city + ", district=" + district + ", state=" + state + "]";
	}

	@Override
	public Shop clone() throws CloneNotSupportedException {

		Shop cloneObj = new Shop();

		cloneObj.city = this.city;
		cloneObj.district = this.district;
		cloneObj.id = this.id;
		cloneObj.landmark = this.landmark;
		cloneObj.name = this.name;
		cloneObj.owner = this.owner;
		cloneObj.state = this.state;
		cloneObj.street = this.street;

		return cloneObj;
	}

}
