package com.expo.springdatajpaandhibernategeneralconcepts.brand.service;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.request.CreateBrandRequest;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response.CreateBrandResponse;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import com.expo.springdatajpaandhibernategeneralconcepts.brand.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class CreateBrandService {

	private final BrandRepository brandRepository;

	public CreateBrandResponse execute(CreateBrandRequest request){

		Brand newBrand = Brand.of(request.name(), request.foundationYear());

		brandRepository.save(newBrand);

		return CreateBrandResponse.of(newBrand.getId(), newBrand.getName(), newBrand.getFoundationYear());
	}
}
