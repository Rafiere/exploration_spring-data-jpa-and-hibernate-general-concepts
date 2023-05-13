package com.expo.springdatajpaandhibernategeneralconcepts.brand.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Brand {

	@Getter @Id private String id;

	@Getter private String name;

	@Getter private Integer foundationYear;

	private Brand(String id, String name, Integer foundationYear){
		this.id = id;
		this.name = name;
		this.foundationYear = foundationYear;
	}

	public static Brand of(String name, Integer foundationYear){
		return new Brand(UUID.randomUUID().toString(), name, foundationYear);
	}

	public Brand update(String name, Integer foundationYear) {
		if(!name.isBlank()){
			this.name = name;
		}

		if(foundationYear != null){
			this.foundationYear = foundationYear;
		}

		return this;
	}
}
