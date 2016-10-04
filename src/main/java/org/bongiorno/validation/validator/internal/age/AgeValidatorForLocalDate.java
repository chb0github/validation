package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;

public class AgeValidatorForLocalDate extends AbstractAgeValidator<LocalDate> {

	@Override
	LocalDate convert(LocalDate birthday) {
		return birthday;
	}
	
}
