package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class AgeValidatorForOffsetDateTime extends AbstractAgeValidator<OffsetDateTime> {
	
	@Override
	ZoneId getZoneId(OffsetDateTime context) {
		return context.getOffset();
	}
	
	@Override
	LocalDate convert(OffsetDateTime birthday) {
		return birthday.toLocalDate();
	}
	
}
