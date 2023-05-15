package com.expo.springdatajpaandhibernategeneralconcepts.hibernate.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;
import java.time.LocalDate;

/* Antes do JPA 2.2, o Hibernate não possuia suporte para o "LocalDate", o "LocalTime" e o "LocalDateTime", assim, era
* necessária a implementação desse Converter, para sempre que, antes do Hibernate salvar ou obter um dado do tipo "LocalDate", por
* exemplo, ele transformasse no tipo "java.sql.Date". */

/* Após o JPA 2.2, isso não foi mais necessário, pois ele definiu o suporte para a nova API de datas do Java 8. */

/* O Hibernate 5 possuia uma implementação própria dessa conversão, mas, após o JPA 2.2, ela passou a ser definida na especificação e
* tornou-se obrigatória para os ORMs. */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {

		if(localDate != null){
			return Date.valueOf(localDate);
		} else {
			return null;
		}
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dateSql) {

		if(dateSql != null){
			return dateSql.toLocalDate();
		} else {
			return null;
		}
	}
}
