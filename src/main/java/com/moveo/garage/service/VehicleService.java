package com.moveo.garage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveo.garage.exception.NotFoundException;
import com.moveo.garage.exception.NullUtil;
import com.moveo.garage.model.vehicle.Vehicle;
import com.moveo.garage.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {
	@Autowired
	private VehicleRepository repo;
	@Autowired
	private NullUtil nullUtil;
	
	/**
	 * adds the vehicle if not null and return it with the generated id
	 * if null - returns null
	 * @param vehicle
	 * @return the given vehicle after being saved and given id
	 */
	@Transactional(readOnly = false)
	public Vehicle addVehicle(Vehicle vehicle) {
		if(vehicle != null) {
			return repo.save(vehicle);
		}
		return null;
	}
	
	/**
	 * adds the energy percentage to the vehicle while maintaining it between 0-100%
	 * @param liscence
	 * @param energy percentage to add
	 * @throws NullException- if licence is null
	 * @throws NotFoundException - if no such vehicle was found
	 */
	@Transactional(readOnly = false)
	public void addEnergyByLicense(String license, double energy) {
		Vehicle vehicle = getByLicense(license);
		double filled = vehicle.getAvailableEnergyPercentage()+energy;
		if(filled>100) {
			filled = 100;
		} else if(filled<0) {
			filled = 0;
		}
		vehicle.setAvailableEnergyPercentage(filled);
		repo.save(vehicle);
	}
	
	/**
	 * fills the energy in the vehicle to 100%
	 * @param licence
	 * @throws NullException- if licence is null
	 * @throws NotFoundException - if no such vehicle was found
	 */
	@Transactional(readOnly = false)
	public void fillEnergyByLicense(String license) {
		Vehicle vehicle = getByLicense(license);
		vehicle.addEnergy();
		repo.save(vehicle);
	}
	
	private Vehicle getByLicense(String license) {
		nullUtil.check(license, "liscense", "fill energy by liscence");
		Optional<Vehicle> optionalVehicle = repo.findByLicense(license);
		if(optionalVehicle.isEmpty()) {
			throw new NotFoundException("vehicle: "+license);
		}
		return optionalVehicle.get();
	}
	
	/**
	 * 
	 * @param licence
	 * @return optional of the vehicle if one exists
	 * @throws NullException- if licence is null
	 */
	public Optional<Vehicle> getOneVehicle(String license) {
		nullUtil.check(license, "license", "get one vehicle");
		return repo.findByLicense(license);
	}
	
	/**
	 * 
	 * @return list of all vehicles
	 */
	public List<Vehicle> getAllVehicles() {
		return repo.findAll();
	}
	
	/**
	 * 
	 * @return all the vehicles sorted by licence in ascending order
	 */
	public List<Vehicle> getAllVehiclesLicenceSorted() {
		return repo.findByOrderByLicenseAsc();
	}
	
	/**
	 * 
	 * @return all the vehicles sorted by module name in ascending order
	 */
	public List<Vehicle> getAllVehiclesModelSorted() {
		return repo.findByOrderByModelNameAsc();
	}
	
	/**
	 * 
	 * @return all the vehicles sorted by available energy percentage in descending order
	 */
	public List<Vehicle> getAllVehiclesEnergySorted() {
		return repo.findByOrderByAvailableEnergyPercentageDesc();
	}
	
	/**
	 * sets all pressure of the vehicle's car to their max pressure
	 * @param licence
	 * @throws NullException- if licence is null
	 * @throws NotFoundException - if no such vehicle was found
	 */
	public void inflateTires(String license) {
		Vehicle vehicle = getByLicense(license);
		inflateTires(vehicle);
	}
	
	/**
	 * sets all pressure of the vehicle's car to their max pressure
	 * @param vehicleId
	 * @throws NullException- if id is null
	 * @throws NotFoundException - if no such vehicle was found
	 */
	public void inflateTires(Integer vehicleId) {
		nullUtil.check(vehicleId, "vehicle id", "inflate tires");
		Optional<Vehicle> optionalVehicle = repo.findById(vehicleId);
		if(optionalVehicle.isEmpty()) {
			throw new NotFoundException("vehicle");
		}
		inflateTires(optionalVehicle.get());
	}
	
	private void inflateTires(Vehicle vehicle) {
		vehicle.inflateTires();
		repo.save(vehicle);
	}
	
}
