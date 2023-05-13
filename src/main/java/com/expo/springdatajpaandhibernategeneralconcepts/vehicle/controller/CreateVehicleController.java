package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.request.CreateVehicleRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.controller.response.CreateVehicleResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.vehicle.service.CreateVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateVehicleController {

	private final CreateVehicleService createVehicleService;

	@PostMapping("/v1/cars")
	public ResponseEntity<CreateVehicleResponse> execute(@RequestBody CreateVehicleRequest request){

		var response = createVehicleService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
