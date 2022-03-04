package com.moveo.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.moveo.garage.model.vehicle.Vehicle;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Wheel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Column(nullable = false)
	private Double maxPressure;
	private Double pressure;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	private Vehicle vehicle;

	public void inflate() {
		pressure = maxPressure;
	}

	public Wheel(Double maxPressure, Double pressure, Vehicle vehicle) {
		super();
		this.maxPressure = maxPressure;
		this.pressure = pressure;
		this.vehicle = vehicle;
	}
}
