package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.EnergySource;

@Entity
@DiscriminatorValue(value = "REG_CAR")
public class RegularCar extends Car {
	public RegularCar() {
		setEnergySource(EnergySource.FUEL_TANK);
	}

	public RegularCar(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		setEnergySource(EnergySource.FUEL_TANK);
	}
	
	
}
