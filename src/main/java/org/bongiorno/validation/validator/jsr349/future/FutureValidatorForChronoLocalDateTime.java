package org.bongiorno.validation.validator.jsr349.future;

import org.bongiorno.validation.validator.AbstractConstraintValidator;

import javax.validation.Configuration;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

/**
 * Validates a {@link Future} constraint against {@link ChronoLocalDateTime}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 *
 */
public class FutureValidatorForChronoLocalDateTime extends AbstractConstraintValidator<Future, ChronoLocalDateTime<?>> {

	public FutureValidatorForChronoLocalDateTime() {
		super((date,c) -> date.isAfter(LocalDateTime.now()));
	}
}
