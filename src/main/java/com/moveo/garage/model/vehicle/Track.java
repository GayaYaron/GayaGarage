package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TRUCK")
public class Track extends Vehicle {
	public Track() {
		this.wheelAmount = 16;
	}
}
