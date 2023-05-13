package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response;

public record GetBrandByIdResponse(String id, String name, Integer foundationYear) {

	public static GetBrandByIdResponse of(String id, String name, Integer foundationYear){
		return new GetBrandByIdResponse(id, name, foundationYear);
	}
}
