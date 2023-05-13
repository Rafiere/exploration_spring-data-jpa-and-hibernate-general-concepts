package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.request.CreateVehicleRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.response.CreateVehicleResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.model.Vehicle;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateVehicleService {

	private final VehicleRepository vehicleRepository;
	private final BrandRepository brandRepository;

	public CreateVehicleResponse execute(CreateVehicleRequest request){

		Brand brand = brandRepository.findById(request.brandId()).orElseThrow(() -> new IllegalArgumentException("A brand with ID " + request.brandId() + " does not exist"));

		Vehicle newVehicle = Vehicle.of(brand, request.vehicleType());

		vehicleRepository.save(newVehicle);

		return CreateVehicleResponse.of(newVehicle.getId(), newVehicle.getBrand().getName());
	}
}
