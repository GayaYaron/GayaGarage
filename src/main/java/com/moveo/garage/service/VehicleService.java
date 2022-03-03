package com.moveo.garage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveo.garage.exception.NotFoundException;
import com.moveo.garage.exception.NullUtil;
import com.moveo.garage.model.Wheel;
import com.moveo.garage.model.vehicle.Vehicle;
import com.moveo.garage.repository.VehicleRepository;
import com.moveo.garage.repository.WheelRepository;

@Service
@Transactional
public class VehicleService {
	@Autowired
	private VehicleRepository repo;
	@Autowired
	private WheelRepository wheelRepo;
	@Autowired
	private NullUtil nullUtil;
	
	/**
	 * adds the vehicle if not null and return it with the generated id
	 * if null - returns null
	 * @param vehicle
	 * @return the given vehicle after being saved and given id
	 */
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
	public void addEnergyByLicence(String licence, double energy) {
		Vehicle vehicle = getByLicence(licence);
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
	public void fillEnergyByLicence(String licence) {
		Vehicle vehicle = getByLicence(licence);
		vehicle.setAvailableEnergyPercentage(100.0);
		repo.save(vehicle);
	}
	
	private Vehicle getByLicence(String licence) {
		nullUtil.check(licence, "liscence", "fill energy by liscence");
		Optional<Vehicle> optionalVehicle = repo.findByLicence(licence);
		if(optionalVehicle.isEmpty()) {
			throw new NotFoundException("vehicle: "+licence);
		}
		return optionalVehicle.get();
	}
	
	/**
	 * 
	 * @param licence
	 * @return optional of the vehicle if one exists
	 * @throws NullException- if licence is null
	 */
	public Optional<Vehicle> getOneVehicle(String licence) {
		nullUtil.check(licence, "licence", "get one vehicle");
		return repo.findByLicence(licence);
	}
	
	/**
	 * 
	 * @return list of all vehicles
	 */
	public List<Vehicle> getAllVehicles() {
		return repo.findAll();
	}
	
	/**
	 * sets all pressure of the vehicle's car to their max pressure
	 * @param licence
	 * @throws NullException- if licence is null
	 * @throws NotFoundException - if no such vehicle was found
	 */
	public void inflateTires(String licence) {
		Vehicle vehicle = getByLicence(licence);
		inflateTires(vehicle.getId());
	}
	
	/**
	 * sets all pressure of the vehicle's car to their max pressure
	 * @param vehicleId
	 * @throws NullException- if id is null
	 */
	public void inflateTires(Integer vehicleId) {
		nullUtil.check(vehicleId, "vehicle id", "inflate tires");
		List<Wheel> wheels = wheelRepo.findByVehicleId(vehicleId);
		for (Wheel wheel : wheels) {
			wheel.setPressure(wheel.getMaxPressure());
			wheelRepo.save(wheel);
		}
	}
}
