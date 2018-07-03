package com.restservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restservices.model.VehicleType;
import com.restservices.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicles/{vehicleId}/vehicleTypes")
	public List<VehicleType> retrieveVehicleTypesForVehicle(@PathVariable String vehicleId) {
		return vehicleService.retrieveVehicleTypes(vehicleId);
	}

	@GetMapping("/vehicles/{vehicleId}/vehicleTypes/{vehicleTypeId}")
	public VehicleType retrieveDetailsForVehicleType(@PathVariable String vehicleId, @PathVariable String vehicleTypeId) {
		return vehicleService.retrieveVehicleType(vehicleId, vehicleTypeId);
	}

	@PostMapping("/vehicles/{vehicleId}/vehicleTypes")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable String vehicleId,
			@RequestBody VehicleType vehicleType) {

		VehicleType vehicleTyp = vehicleService.addVehicleType(vehicleId, vehicleType);

		if (vehicleTyp == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicleType.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}