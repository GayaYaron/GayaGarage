package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MOTORCYCLE")
public abstract class Motorcycle extends Vehicle {
	public Motorcycle() {
		this.wheelAmount = 2;
	}
}
