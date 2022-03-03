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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Wheel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	//I like to use both notNull and nullable false so that it will be enforced from both places
	@NotNull
	@Column(nullable = false)
	private Double maxPressure;
	private Double pressure;
	@ManyToOne
	private Vehicle vehicle;

}
