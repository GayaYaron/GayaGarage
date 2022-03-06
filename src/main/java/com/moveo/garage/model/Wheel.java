package com.moveo.garage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;

	public void inflate() {
		pressure = maxPressure;
	}

	public Wheel(Double maxPressure, Double pressure) {
		super();
		this.maxPressure = maxPressure;
		setPressure(pressure);
	}
	
	/**
	 * sets the pressure while keeping it between 0 to max pressure
	 * @param pressure
	 */
	public void setPressure(Double pressure) {
		if(pressure!=null) {
			if(pressure>maxPressure) {
				this.pressure = maxPressure;
			}else if(pressure<0) {
				this.pressure = 0.0;
			}else {
				this.pressure = pressure;
			}
		}
	}
}
