package com.moveo.garage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.moveo.garage.model.Wheel;
import com.moveo.garage.model.vehicle.ElectricCar;
import com.moveo.garage.model.vehicle.ElectricMotorcycle;
import com.moveo.garage.model.vehicle.RegularCar;
import com.moveo.garage.model.vehicle.RegularMotorcycle;
import com.moveo.garage.model.vehicle.Truck;
import com.moveo.garage.model.vehicle.Vehicle;
import com.moveo.garage.service.VehicleService;

@SpringBootApplication
public class GarageApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GarageApplication.class, args);
//		VehicleService service = context.getBean(VehicleService.class);
//		
//		System.out.println("                adding five vehicles...");
//		RegularCar regularCar = new RegularCar("John", 85.2, "2124175");
//		service.addVehicle(regularCar);
//		Vehicle electricCar = new ElectricCar("Jannette", 26.5, "A25GOH6");
//		service.addVehicle(electricCar);
//		service.addVehicle(new ElectricMotorcycle("John", 68.7, "6517181"));
//		service.addVehicle(new RegularMotorcycle("Molly", 98.5, "2316485"));
//		service.addVehicle(new Truck("Miley", 10.5, "PH2K687L"));
//		
//		System.out.println("                all vehicles from the db:");
//		System.out.println(service.getAllVehicles());
//		
//		System.out.println("\n                adding 5% energy to the regular car:");
//		service.addEnergyByLicense("2124175", 5.0);
//		System.out.println(service.getOneVehicle("2124175"));
//		
//		System.out.println("\n                adding 55% energy to the regular car:");
//		service.addEnergyByLicense("2124175", 55.0);
//		System.out.println(service.getOneVehicle("2124175"));
//		
//		try {
//			System.out.println("\n                adding 5% to null license:");
//			service.addEnergyByLicense(null, 5.0);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		try {
//			System.out.println("\n                adding 5% to not exist license:");
//			service.addEnergyByLicense("hellothere", 5.0);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		System.out.println("\n                filling truck:");
//		service.fillEnergyByLicense("PH2K687L");
//		System.out.println(service.getOneVehicle("PH2K687L"));
//		
//		System.out.println("\n                all sorted by license:");
//		System.out.println(service.getAllVehiclesLicenseSorted());
//		
//		System.out.println("\n                all sorted by energy:");
//		System.out.println(service.getAllVehiclesEnergySorted());
//		
//		System.out.println("\n                all sorted by model:");
//		System.out.println(service.getAllVehiclesModelSorted());
//		
//		System.out.println("\n                adding new car with wheels:");
//		ElectricCar wheely = new ElectricCar("Wheely", 56.8, "M98K612");
//		List<Wheel> wheels = new ArrayList<Wheel>(4);
//		wheels.add(new Wheel(100.0, 88.3, wheely));
//		wheels.add(new Wheel(100.0, 90.0, wheely));
//		wheels.add(new Wheel(100.0, 89.3, wheely));
//		wheels.add(new Wheel(75.5, 75.0, wheely));
//		wheely.setWheels(wheels);
//		System.out.println(service.addVehicle(wheely));
//		
//		System.out.println("\n                inflating tires by license:");
//		service.inflateTires("M98K612");
//		System.out.println(service.getOneVehicle("M98K612"));
//		
//		try {
//			System.out.println("\n                trying to add 3 wheels to regular car:");
//			List<Wheel> wheels2 = new ArrayList<Wheel>(4);
//			wheels2.add(new Wheel(100.0, 88.3, regularCar));
//			wheels2.add(new Wheel(100.0, 90.0, regularCar));
//			wheels2.add(new Wheel(100.0, 89.3, regularCar));
//			regularCar.setWheels(wheels2);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	}

}
