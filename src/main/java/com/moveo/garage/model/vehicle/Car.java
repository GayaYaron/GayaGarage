package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CAR")
public abstract class Car extends Vehicle {
	public Car() {
		this.wheelAmount = 4;
	}

	public Car(String modelName, Double availableEnergyPercentage, String license) {
		super(modelName, availableEnergyPercentage, license);
		this.wheelAmount = 4;
	}
}
