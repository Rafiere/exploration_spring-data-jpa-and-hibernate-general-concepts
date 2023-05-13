package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.GetBrandByIdResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.service.GetBrandByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetBrandByIdController {

	private final GetBrandByIdService getBrandByIdService;

	@GetMapping("/v1/brands/{brandId}")
	public ResponseEntity<GetBrandByIdResponse> execute(@PathVariable String brandId){

		var response = getBrandByIdService.execute(brandId);

		return ResponseEntity.status(200).body(response);
	}
}
