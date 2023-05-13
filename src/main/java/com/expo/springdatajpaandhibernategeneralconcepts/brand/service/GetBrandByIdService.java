package com.expo.springdatajpaandhibernategeneralconcepts.brand.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.GetBrandByIdResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class GetBrandByIdService {

	private final BrandRepository brandRepository;

	public GetBrandByIdResponse execute(String brandId) {

		Brand brand = brandRepository.findById(brandId)
		                             .orElseThrow(() -> new IllegalArgumentException("A brand with ID " +
		                                                               brandId +
		                                                               " does not exist"));

		return GetBrandByIdResponse.of(brand.getId(), brand.getName(), brand.getFoundationYear());
	}
}
