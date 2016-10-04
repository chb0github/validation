package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AgeValidatorForDate extends AbstractAgeValidator<Date> {

	@Override
	LocalDate convert(Date birthday) {
		return birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
