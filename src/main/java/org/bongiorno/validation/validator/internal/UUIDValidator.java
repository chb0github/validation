package org.bongiorno.validation.validator.internal;

import org.bongiorno.validation.constraints.UUID;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

import java.util.regex.Pattern;

public class UUIDValidator extends AbstractConstraintValidator<UUID, String> {

    //https://tools.ietf.org/html/rfc4122#section-3
	// https://www.itu.int/rec/dologin_pub.asp?lang=e&id=T-REC-X.667-201210-I!!PDF-E&type=items
	private static final Pattern PATTERN = Pattern.compile("^\\p{XDigit}{8}-\\p{XDigit}{4}-[1-5]\\p{XDigit}{3}-[89abAB]\\p{XDigit}{3}-\\p{XDigit}{12}$");

	public UUIDValidator() {
		super((v,c) -> PATTERN.matcher(v).matches());
	}
}
