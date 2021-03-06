package org.bongiorno.validation.validator.jsr349.past;

import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Past;

/**
 * Validates a {@link Past} constraint against {@link ChronoZonedDateTime}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 *
 */
public class PastValidatorForChronoZonedDateTime implements ConstraintValidator<Past, ChronoZonedDateTime<?>> {
	
	@Override
	public void initialize(Past constraintAnnotation) {
	}

	@Override
	public boolean isValid(ChronoZonedDateTime<?> date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		return date.isBefore(ZonedDateTime.now());
	}

}
