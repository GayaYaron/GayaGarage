package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TRUCK")
public class Track extends Vehicle {
	public Track() {
		this.wheelAmount = 16;
	}

	public Track(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
	}
	
}
