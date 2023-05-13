package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.repository;

import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
