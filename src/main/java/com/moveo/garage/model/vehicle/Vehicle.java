package com.moveo.garage.model.vehicle;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.moveo.garage.exception.MismatchingWheelAmountException;
import com.moveo.garage.model.EnergySource;
import com.moveo.garage.model.Wheel;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "vehicleType")
@JsonSubTypes({ @JsonSubTypes.Type(value = ElectricCar.class, name = "ElectricCar"),
		@JsonSubTypes.Type(value = RegularCar.class, name = "RegularCar"),
		@JsonSubTypes.Type(value = ElectricMotorcycle.class, name = "ElectricMotorcycle"),
		@JsonSubTypes.Type(value = RegularMotorcycle.class, name = "RegularMotorcycle"),
		@JsonSubTypes.Type(value = Truck.class, name = "Truck") })
public abstract class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Enumerated(value = EnumType.STRING)
	private EnergySource energySource;
	private String modelName;
	private Double availableEnergyPercentage;
	private String license;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle")
	private List<Wheel> wheels;
	protected Integer wheelAmount;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnergySource getEnergySource() {
		return energySource;
	}

	public void setEnergySource(EnergySource energySource) {
		this.energySource = energySource;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModuleName(String modelName) {
		this.modelName = modelName;
	}

	public Double getAvailableEnergyPercentage() {
		return availableEnergyPercentage;
	}

	public void setAvailableEnergyPercentage(Double availableEnergyPercentage) {
		this.availableEnergyPercentage = availableEnergyPercentage;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void addEnergy() {
		setAvailableEnergyPercentage(100.0);
	}

	public void inflateTires() {
		for (Wheel wheel : wheels) {
			wheel.inflate();
		}
	}

	public Vehicle(String modelName, Double availableEnergyPercentage, String license) {
		super();
		this.modelName = modelName;
		this.availableEnergyPercentage = availableEnergyPercentage;
		this.license = license;
	}

	@Override
	public String toString() {
		return "Vehicle [energySource=" + energySource + ", modelName=" + modelName + ", availableEnergyPercentage="
				+ availableEnergyPercentage + ", license=" + license + ", wheels=" + wheels + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableEnergyPercentage == null) ? 0 : availableEnergyPercentage.hashCode());
		result = prime * result + ((energySource == null) ? 0 : energySource.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + ((wheelAmount == null) ? 0 : wheelAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (availableEnergyPercentage == null) {
			if (other.availableEnergyPercentage != null)
				return false;
		} else if (!availableEnergyPercentage.equals(other.availableEnergyPercentage))
			return false;
		if (energySource != other.energySource)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (wheelAmount == null) {
			if (other.wheelAmount != null)
				return false;
		} else if (!wheelAmount.equals(other.wheelAmount))
			return false;
		return true;
	}
}
