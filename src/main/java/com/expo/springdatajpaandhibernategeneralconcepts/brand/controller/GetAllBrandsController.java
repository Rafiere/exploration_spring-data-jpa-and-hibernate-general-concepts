package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.GetBrandByIdResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.service.GetAllBrandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllBrandsController {

	private final GetAllBrandsService getAllBrandsService;

	@GetMapping("/v1/brands")
	public ResponseEntity<List<GetBrandByIdResponse>> execute(){

		var response = getAllBrandsService.execute();

		return ResponseEntity.status(200).body(response);
	}
}
