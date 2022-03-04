package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.EnergySource;

@Entity
@DiscriminatorValue(value = "REG_MOTORCYCLE")
public class RegularMotorcycle extends Motorcycle {
	public RegularMotorcycle() {
		setEnergySource(EnergySource.FUEL_TANK);
	}

	public RegularMotorcycle(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		setEnergySource(EnergySource.FUEL_TANK);
	}
}
