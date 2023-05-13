package com.expo.springdatajpaandhibernategeneralconcepts.brand.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.DeleteBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteBrandService {

	private final BrandRepository brandRepository;

	public DeleteBrandResponse execute(String brandId) {

		Brand deletedBrand = brandRepository.findById(brandId)
		                                    .orElseThrow(() -> new IllegalArgumentException("A brand with ID " +
		                                                                                    brandId +
		                                                                                    " does not exist"));

		return DeleteBrandResponse.of(deletedBrand.getId(), deletedBrand.getName(), deletedBrand.getFoundationYear());
	}
}
