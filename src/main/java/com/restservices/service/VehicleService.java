package com.restservices.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restservices.model.Vehicle;
import com.restservices.model.VehicleType;

@Component
public class VehicleService {

	private static List<Vehicle> vehicles = new ArrayList<>();

	static {
		// Initialize Data
		VehicleType vehicleType1 = new VehicleType("VehicleType1", "Sedan", "Sedan Car",
				Arrays.asList("Air Bags", "Leather seats", "Head Lights", "No tires"));
		VehicleType vehicleType2 = new VehicleType("VehicleType2", "SUV", "Sport Utility Vehicle",
				Arrays.asList("Head Lights", "Seat holders", "Seat covers", "Seats"));
		VehicleType vehicleType3 = new VehicleType("VehicleType3", "HatchBack", "NO Truck Car",
				Arrays.asList("Fours Tires", "Spare tire", "Spare headlights", "Spare seats", "Rentals no use"));
		VehicleType vehicleType4 = new VehicleType("VehicleType4", "Mini Van", "Full comfort Mini Van",
				Arrays.asList("5 Tires", "Streeing wheel", "7 people in a car", "7 Seater"));

		Vehicle infiniti = new Vehicle("Vehicle1", "Infiniti", "Q50",
				new ArrayList<>(Arrays.asList(vehicleType1, vehicleType3)));

		Vehicle focus = new Vehicle("Vehicle2", "Ford Focus", "Ford Focus",
				new ArrayList<>(Arrays.asList(vehicleType2, vehicleType3, vehicleType4)));

		vehicles.add(infiniti);
		vehicles.add(focus);
	}

	public List<Vehicle> retrieveAllVehicles() {
		return vehicles;
	}

	public Vehicle retrieveVehicle(String vehicleId) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getId().equals(vehicleId)) {
				return vehicle;
			}
		}
		return null;
	}

	public List<VehicleType> retrieveVehicleTypes(String vehicleId) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getId().equals(vehicleId)) {
				return vehicle.getVehicleTypes();
			}
		}
		return null;
	}

	public VehicleType retrieveVehicleType(String vehicleId, String vehicleTypeId) {
		Vehicle Vehicle = retrieveVehicle(vehicleId);

		if (Vehicle == null) {
			return null;
		}

		for (VehicleType vehicleType : Vehicle.getVehicleTypes()) {
			if (vehicleType.getId().equals(vehicleTypeId)) {
				return vehicleType;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public VehicleType addVehicleType(String vehicleId, VehicleType vehicleType) {
		Vehicle vehicle = retrieveVehicle(vehicleId);

		if (vehicle == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		vehicleType.setId(randomId);

		vehicle.getVehicleTypes().add(vehicleType);

		return vehicleType;
	}
}
