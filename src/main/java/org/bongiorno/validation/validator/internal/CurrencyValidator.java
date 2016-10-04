package org.bongiorno.validation.validator.internal;


import org.bongiorno.validation.constraints.CurrencyCode;
import org.bongiorno.validation.validator.AbstractConstraintValidator;

import java.util.Currency;
import java.util.Set;

import static java.util.Currency.getAvailableCurrencies;
import static java.util.stream.Collectors.toSet;

public class CurrencyValidator extends AbstractConstraintValidator<CurrencyCode,String> {

    private static final Set<String> CODES = getAvailableCurrencies().stream().map(Currency::getCurrencyCode).collect(toSet());

    public CurrencyValidator() {
        super((v,c) -> CODES.contains(v));
    }
}
