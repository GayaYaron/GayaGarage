package com.moveo.garage.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveo.garage.model.Wheel;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Integer>{
	public List<Wheel> findByVehicleId(Integer vehicleId);
	public Optional<Wheel> findByIdAndVehicleId(Integer id, Integer vehicleId);
}
