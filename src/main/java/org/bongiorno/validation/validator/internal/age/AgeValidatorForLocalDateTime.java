package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgeValidatorForLocalDateTime extends AbstractAgeValidator<LocalDateTime> {
	
	@Override
	LocalDate convert(LocalDateTime birthday) {
		return birthday.toLocalDate();
	}
	
}
