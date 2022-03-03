package com.moveo.garage.model.vehicle;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moveo.garage.exception.MismatchingWheelAmountException;
import com.moveo.garage.model.Wheel;
import com.moveo.garage.model.energy.EnergySource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Enumerated(value = EnumType.STRING)
	private EnergySource energySource;
	private String moduleName;
	private Double availableEnergyPercentage;
	private String licence;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "vehicle")
	private List<Wheel> wheels;
	protected Integer wheelAmount;

	/*
	 * I have chosen to add the method to the model because it is part of the
	 * definition of the vehicle itself- therefore belongs here and not in a service
	 */
	/**
	 * sets the vehicle's wheels to the given wheels if the amount matches the
	 * vehicle needed wheel amount
	 * 
	 * @param wheels
	 * @throws MismatchingWheelAmountException if the amount of given wheels (the
	 *                                         size of the set) does not match the
	 *                                         required amount
	 */
	public void setWheels(List<Wheel> wheels) {
		int amount = wheels.size();
		if (amount == wheelAmount) {
			this.wheels = wheels;
		} else {
			throw new MismatchingWheelAmountException(this.getClass().getSimpleName(), wheelAmount, amount);
		}
	}
	
	
}
