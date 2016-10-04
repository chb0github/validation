package org.bongiorno.validation.validator.internal.age;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class AgeValidatorForInstant extends AbstractAgeValidator<Instant> {
	
	@Override
	LocalDate convert(Instant birthday) {
		return birthday.atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
}
