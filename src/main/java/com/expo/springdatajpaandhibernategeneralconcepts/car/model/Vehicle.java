package com.expo.springdatajpaandhibernategeneralconcepts.car.model;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Vehicle {

	@Getter @Id private String id;

	@Getter @OneToOne private Brand brand;

	@Enumerated(EnumType.STRING)
	@Getter private VehicleType vehicleType;

//	Por padrão, os objetos do tipo "Date" são mapeados para o "TIMESTAMP(6)", no Postgres, porém, de acordo com o
//  valor da anotação "@Temporal", podemos mapear como "TIMESTAMP(6)", "DATE" ou "TIME".
//	@Temporal(TemporalType.DATE)
//	@Getter private Date storeEntryDate;

	public static Vehicle of(Brand brand, VehicleType vehicleType){
		return new Vehicle(brand, vehicleType);
	}

	private Vehicle(Brand brand, VehicleType vehicleType){
		this.id = UUID.randomUUID().toString();
		this.brand = brand;
		this.vehicleType = vehicleType;
	}
}
