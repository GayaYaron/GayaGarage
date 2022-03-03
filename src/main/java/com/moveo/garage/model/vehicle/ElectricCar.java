package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.energy.Electric;

@Entity
@DiscriminatorValue(value = "ELECTRIC_CAR")
public class ElectricCar extends Car implements Electric{

}
