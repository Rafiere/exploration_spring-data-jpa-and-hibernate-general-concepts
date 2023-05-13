package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.request.UpdateBrandRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.CreateBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.service.UpdateBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateBrandController {

	private final UpdateBrandService updateBrandService;

	@PutMapping("/v1/brands/{brandId}")
	public ResponseEntity<CreateBrandResponse> execute(@PathVariable String brandId, @RequestBody UpdateBrandRequest request){

		var response = updateBrandService.execute(brandId, request);

		return ResponseEntity.status(201).body(response);
	}
}
