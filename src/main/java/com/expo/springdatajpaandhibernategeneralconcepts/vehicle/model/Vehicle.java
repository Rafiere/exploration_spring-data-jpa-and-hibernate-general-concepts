package com.expo.springdatajpaandhibernategeneralconcepts.vehicle.model;

import com.expo.springdatajpaandhibernategeneralconcepts.brand.domain.Brand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
//O "name" é o nome da tabela que será criada, e o "schema" é o schema utilizado na tabela.
//@Table(name = "vehicle_table", schema = "test")
public class Vehicle {

	@Getter @Id private String id;

	//Esse é um relacionamento "@OneToOne" unidirecional.
	@Getter @OneToOne private Brand brand;

	@Enumerated(EnumType.STRING)
	@Getter private VehicleType vehicleType;

//	//Após o JPA 2.2, esse tipo foi aceito nativamente. Antes, para ele ser aceito, um "AttributeConverter" deveria ser implementado.
//	@Getter private LocalDate storeEntryDate;

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
