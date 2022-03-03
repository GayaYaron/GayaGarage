package com.moveo.garage.model.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.moveo.garage.model.energy.Fueled;
@Entity
@DiscriminatorValue(value = "REG_MOTORCYCLE")
public class RegularMotorcycle extends Motorcycle implements Fueled{

}
