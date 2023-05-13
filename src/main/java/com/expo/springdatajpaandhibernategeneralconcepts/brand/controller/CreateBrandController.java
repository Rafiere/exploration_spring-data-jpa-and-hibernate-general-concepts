package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.request.CreateBrandRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.CreateBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.service.CreateBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateBrandController {

	private final CreateBrandService createBrandService;

	@PostMapping("/v1/brands")
	public ResponseEntity<CreateBrandResponse> execute(@RequestBody CreateBrandRequest request){

		var response = createBrandService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
