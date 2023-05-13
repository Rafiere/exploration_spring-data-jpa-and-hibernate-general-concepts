package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response;

public record CreateBrandResponse(String id, String name, Integer foundationYear) {

	public static CreateBrandResponse of(String id, String name, Integer foundationYear){
		return new CreateBrandResponse(id, name, foundationYear);
	}
}
