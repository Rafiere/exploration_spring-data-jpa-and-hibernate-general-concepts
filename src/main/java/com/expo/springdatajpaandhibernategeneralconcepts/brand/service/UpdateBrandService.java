package com.expo.springdatajpaandhibernategeneralconcepts.brand.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.request.UpdateBrandRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.CreateBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateBrandService {

	private final BrandRepository brandRepository;

	public CreateBrandResponse execute(String brandId, UpdateBrandRequest request) {

		Brand brand = brandRepository.findById(brandId)
		                             .orElseThrow(() -> new IllegalArgumentException("A brand with ID " +
		                                                               brandId +
		                                                               " does not exist"));

		brand.update(request.name(), request.foundationYear());

		return CreateBrandResponse.of(brand.getId(), brand.getName(), brand.getFoundationYear());
	}
}
