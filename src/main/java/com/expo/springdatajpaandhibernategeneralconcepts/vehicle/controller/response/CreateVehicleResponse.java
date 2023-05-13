package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.response;

public record CreateVehicleResponse(String id, String brand) {

	public static CreateVehicleResponse of(String id, String brand){
		return new CreateVehicleResponse(id, brand);
	}
}
