package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.request;

import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.model.VehicleType;

public record CreateVehicleRequest(String brandId, VehicleType vehicleType) {

}
