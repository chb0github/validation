package org.bongiorno.validation.validator.internal.banking;

import fr.marcwrobel.jbanking.iban.Iban;
import org.bongiorno.validation.constraints.banking.IBAN;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

public class IBANValidatorForString extends AbstractConstraintValidator<IBAN, String> {

	public IBANValidatorForString() {
		super((iban,c) -> Iban.isValid(iban));
	}
}
