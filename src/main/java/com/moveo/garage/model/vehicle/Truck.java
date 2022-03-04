package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TRUCK")
public class Truck extends Vehicle {
	public Truck() {
		this.wheelAmount = 16;
	}

	public Truck(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		this.wheelAmount = 16;
	}
	
}
