package com.spring.lesson.inheritance;

public class Vehicle {
	
	private String vehicleType;
	private Car objCar;
	
	public Vehicle(String vehicleType, Car objCar) {
		super();
		System.out.println("Inside vehicle constructor - start");
		this.vehicleType = vehicleType;
		this.objCar = objCar;
		System.out.println("Inside vehicle constructor - end");
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Car getObjCar() {
		return objCar;
	}

	public void setObjCar(Car objCar) {
		this.objCar = objCar;
	}

}
