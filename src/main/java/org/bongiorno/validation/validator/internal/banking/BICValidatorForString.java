package org.bongiorno.validation.validator.internal.banking;

import fr.marcwrobel.jbanking.bic.Bic;
import org.bongiorno.validation.constraints.banking.BIC;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

public class BICValidatorForString extends AbstractConstraintValidator<BIC, String> {

	public BICValidatorForString() {
		super((bic,c) -> Bic.isValid(bic));
	}
}
