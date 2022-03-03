package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CAR")
public abstract class Car extends Vehicle {
	public Car() {
		this.wheelAmount = 4;
	}
}