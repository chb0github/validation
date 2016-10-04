package org.bongiorno.validation.validator.jsr349.past;

import java.time.Year;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Past;

/**
 * Validates a {@link Past} constraint against {@link Year}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 *
 */
public class PastValidatorForYear implements ConstraintValidator<Past, Year> {
	
	@Override
	public void initialize(Past constraintAnnotation) {
	}

	@Override
	public boolean isValid(Year date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		return date.isBefore(Year.now());
	}

}
