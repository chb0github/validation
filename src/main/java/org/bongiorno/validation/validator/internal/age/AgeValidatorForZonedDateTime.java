package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AgeValidatorForZonedDateTime extends AbstractAgeValidator<ZonedDateTime> {
	
	@Override
	ZoneId getZoneId(ZonedDateTime context) {
		return context.getZone();
	}
	
	@Override
	LocalDate convert(ZonedDateTime birthday) {
		return birthday.toLocalDate();
	}
	
}
