package org.bongiorno.validation.validator.jsr349.future;

import org.bongiorno.validation.validator.AbstractConstraintValidator;

import javax.validation.Configuration;
import javax.validation.constraints.Future;
import java.time.OffsetDateTime;

/**
 * Validates a {@link Future} constraint against {@link OffsetDateTime}.
 * 
 * You have to add this validator to the list of constraint validators.
 * This is done by adding the resource META-INF/validation/mapping.xml to
 * your Validation configuration. You have to either create a
 * META-INF/validation.xml and add that mapping or you do it programmatically
 * with {@link Configuration#addMapping(java.io.InputStream)}.
 * 
 *
 */
public class FutureValidatorForOffsetDateTime extends AbstractConstraintValidator<Future, OffsetDateTime> {

	public FutureValidatorForOffsetDateTime() {
		super((v,c) -> v.isAfter(OffsetDateTime.now()));
	}
}
