package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.EnergySource;

@Entity
@DiscriminatorValue(value = "ELECTRIC_CAR")
public class ElectricCar extends Car {
	public ElectricCar() {
		setEnergySource(EnergySource.BATTERY);
	}

	public ElectricCar(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		setEnergySource(EnergySource.BATTERY);
	}
}
