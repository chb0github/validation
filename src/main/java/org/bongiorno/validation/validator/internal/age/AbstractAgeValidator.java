package org.bongiorno.validation.validator.internal.age;

import org.bongiorno.validation.constraints.age.Age;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 */
public abstract class AbstractAgeValidator<T> extends AbstractConstraintValidator<Age, T> {

	private AgeValidatorForPeriod periodValidator = new AgeValidatorForPeriod();

	public AbstractAgeValidator() {
		super.function = (v,c) -> periodValidator.isValid(Period.between(convert(v), LocalDate.now(getZoneId(v))), c);
	}

	abstract LocalDate convert(T birthday);
	
	ZoneId getZoneId(T context) {
		return ZoneId.systemDefault();
	}
	
	@Override
	public void initialize(Age constraintAnnotation) {
		periodValidator.initialize(constraintAnnotation);
	}
	
}
