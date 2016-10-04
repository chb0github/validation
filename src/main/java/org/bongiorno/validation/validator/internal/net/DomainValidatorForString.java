package org.bongiorno.validation.validator.internal.net;

import org.apache.commons.validator.routines.DomainValidator;
import org.bongiorno.validation.constraints.net.Domain;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

public class DomainValidatorForString extends AbstractConstraintValidator<Domain, String> {

	public DomainValidatorForString() {
		super((v,c) -> DomainValidator.getInstance().isValid(v));
	}
}
