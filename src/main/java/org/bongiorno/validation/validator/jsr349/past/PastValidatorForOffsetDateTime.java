package org.bongiorno.validation.validator.jsr349.past;

import java.time.OffsetDateTime;

import javax.validation.Configuration;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Past;

/**
 * Validates a {@link Past} constraint against {@link OffsetDateTime}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 *
 */
public class PastValidatorForOffsetDateTime implements ConstraintValidator<Past, OffsetDateTime> {
	
	@Override
	public void initialize(Past constraintAnnotation) {
	}

	@Override
	public boolean isValid(OffsetDateTime date, ConstraintValidatorContext context) {
		if (date == null) {
			return true;
			
		}
		return date.isBefore(OffsetDateTime.now());
	}

}
