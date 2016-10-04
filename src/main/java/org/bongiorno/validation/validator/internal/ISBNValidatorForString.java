package org.bongiorno.validation.validator.internal;

import org.apache.commons.validator.routines.ISBNValidator;
import org.bongiorno.validation.constraints.ISBN;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.bongiorno.validation.constraints.ISBN.Type.ISBN10;
import static org.bongiorno.validation.constraints.ISBN.Type.ISBN13;

public class ISBNValidatorForString extends AbstractConstraintValidator<ISBN, String>{
	
	private Set<ISBN.Type> types = new HashSet<>();


	public ISBNValidatorForString() {
		super(null);
		ISBNValidator v = ISBNValidator.getInstance();
		super.function = (isbn,c) -> types.contains(ISBN10) && v.isValidISBN10(isbn) || types.contains(ISBN13) && v.isValidISBN13(isbn);
	}

	@Override
	public void initialize(ISBN constraint) {
		types.addAll(Arrays.asList(constraint.value()));
	}

}
