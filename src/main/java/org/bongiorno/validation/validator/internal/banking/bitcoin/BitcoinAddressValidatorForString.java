package org.bongiorno.validation.validator.internal.banking.bitcoin;

import org.bongiorno.validation.constraints.banking.BitcoinAddress;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

public class BitcoinAddressValidatorForString extends AbstractConstraintValidator<BitcoinAddress, String> {
	private static String pattern = String.format("^[13][%s]{26,34}$", Base58.ALPHABET);

	public BitcoinAddressValidatorForString() {
		super((address,c) -> address.matches(pattern) && Base58.isValidChecksum(address));
	}
}
