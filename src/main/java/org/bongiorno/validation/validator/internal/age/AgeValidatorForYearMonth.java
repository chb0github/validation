package org.bongiorno.validation.validator.internal.age;

import java.time.LocalDate;
import java.time.YearMonth;

public class AgeValidatorForYearMonth extends AbstractAgeValidator<YearMonth> {
	
	@Override
	LocalDate convert(YearMonth birthday) {
		return birthday.atDay(1);
	}
	
}
