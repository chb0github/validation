package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.Year;

public class AgeValidatorForYear extends AbstractAgeValidator<Year> {
	
	@Override
	LocalDate convert(Year birthday) {
		return birthday.atDay(1);
	}
	
}
