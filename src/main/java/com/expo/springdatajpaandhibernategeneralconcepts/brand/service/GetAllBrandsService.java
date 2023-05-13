package com.expo.springdatajpaandhibernategeneralconcepts.brand.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.GetBrandByIdResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBrandsService {

	private final BrandRepository brandRepository;

	public List<GetBrandByIdResponse> execute() {

		List<Brand> brands = brandRepository.findAll();

		return brands.stream()
		             .map(brand -> GetBrandByIdResponse.of(brand.getId(), brand.getName(), brand.getFoundationYear()))
		             .toList();
	}
}
