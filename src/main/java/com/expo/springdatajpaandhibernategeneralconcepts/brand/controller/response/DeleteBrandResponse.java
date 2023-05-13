package com.expo.springdatajpaandhibernategeneralconcepts.brand.controller.response;

public record DeleteBrandResponse(String id, String name, Integer foundationYear) {

	public static DeleteBrandResponse of(String id, String name, Integer foundationYear){
		return new DeleteBrandResponse(id, name, foundationYear);
	}
}
