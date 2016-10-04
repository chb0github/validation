package org.bongiorno.validation.validator.internal.net;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.bongiorno.validation.constraints.net.IPv4;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

public class IPv4ValidatorForString extends AbstractConstraintValidator<IPv4, String> {

	public IPv4ValidatorForString() {
		super((v,c) -> InetAddressValidator.getInstance().isValidInet4Address(v));
	}
}
