package com.moveo.garage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moveo.garage.exception.NotFoundException;
import com.moveo.garage.model.vehicle.Vehicle;
import com.moveo.garage.service.VehicleService;

//does not handle exceptions- throws them and lets the exception handler catch them
@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService service;
	
	@PostMapping
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addVehicle(vehicle));
	}
	
	@PutMapping(value = "/add_energy")
	public ResponseEntity<Void> addEnergy(@RequestParam String license, @RequestParam double energy) {
		service.addEnergyByLicense(license, energy);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/fill_energy")
	public ResponseEntity<Void> addEnergy(@RequestParam String license) {
		service.fillEnergyByLicense(license);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<Vehicle> getOne(@RequestParam String license) {
		Optional<Vehicle> optionalVehicle = service.getOneVehicle(license);
		if(optionalVehicle.isEmpty()) {
			throw new NotFoundException("vehicle");
		}
		return ResponseEntity.ok(optionalVehicle.get());
	}
	
	@GetMapping(value = "all")
	public ResponseEntity<List<Vehicle>> getAll() {
		return ResponseEntity.ok(service.getAllVehicles());
	}
	
	@GetMapping(value = "all/by_license")
	public ResponseEntity<List<Vehicle>> getAllByLicense() {
		return ResponseEntity.ok(service.getAllVehiclesLicenseSorted());
	}
	
	@GetMapping(value = "all/by_model")
	public ResponseEntity<List<Vehicle>> getAllByModel() {
		return ResponseEntity.ok(service.getAllVehiclesModelSorted());
	}
	
	@GetMapping(value = "all/by_energy")
	public ResponseEntity<List<Vehicle>> getAllByEnergy() {
		return ResponseEntity.ok(service.getAllVehiclesEnergySorted());
	}
	
	@PutMapping(value = "inflate")
	public ResponseEntity<Void> inflate(@RequestParam String license) {
		service.inflateTires(license);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "inflate")
	public ResponseEntity<Void> inflate(@RequestParam Integer id) {
		service.inflateTires(id);
		return ResponseEntity.ok().build();
	}
}
