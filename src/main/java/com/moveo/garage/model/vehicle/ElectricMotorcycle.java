package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.energy.Electric;

@Entity
@DiscriminatorValue(value = "ELECTRIC_MOTORCYCLE")
public class ElectricMotorcycle extends Motorcycle implements Electric{

}
