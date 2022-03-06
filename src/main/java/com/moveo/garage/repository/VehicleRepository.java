package com.moveo.garage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveo.garage.model.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	public Optional<Vehicle> findByLicense(String license);
	public List<Vehicle> findByOrderByLicenseAsc();
	public List<Vehicle> findByOrderByModelNameAsc();
	public List<Vehicle> findByOrderByAvailableEnergyPercentageDesc();
	public boolean existsByLicense(String license);
}
