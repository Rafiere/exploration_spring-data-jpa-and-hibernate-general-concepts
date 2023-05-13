package com.expo.springdatajpaandhibernategeneralconcepts.brand.repository;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {

}
