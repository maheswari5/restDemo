package com.restservices.model;

import java.util.List;
 
public class Vehicle {
	private String id;
	private String name;
	private String description;
	private List<VehicleType> vehicleTypes;

	public Vehicle(String id, String name, String description,
			List<VehicleType> vehicleTypes) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.vehicleTypes = vehicleTypes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<VehicleType> getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(List<VehicleType> vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [id=%s, name=%s, description=%s, vehicleTypes=%s]", id,
				name, description, vehicleTypes);
	}
}