package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.EnergySource;

@Entity
@DiscriminatorValue(value = "ELECTRIC_MOTORCYCLE")
public class ElectricMotorcycle extends Motorcycle {
	public ElectricMotorcycle() {
		setEnergySource(EnergySource.BATTERY);
	}

	public ElectricMotorcycle(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		setEnergySource(EnergySource.BATTERY);
	}
}
