package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.energy.Fueled;

@Entity
@DiscriminatorValue(value = "REG_CAR")
public class RegularCar extends Car implements Fueled {

}
