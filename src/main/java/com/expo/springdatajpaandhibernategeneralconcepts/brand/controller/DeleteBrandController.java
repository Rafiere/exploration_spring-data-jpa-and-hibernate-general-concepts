package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.DeleteBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.service.DeleteBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteBrandController {

	private final DeleteBrandService deleteBrandService;

	@DeleteMapping("/v1/brands/{brandId}")
	public ResponseEntity<DeleteBrandResponse> execute(@PathVariable String brandId){

		var response = deleteBrandService.execute(brandId);

		return ResponseEntity.status(201).body(response);
	}
}
