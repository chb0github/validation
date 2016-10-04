package org.bongiorno.validation.validator;

import org.bongiorno.validation.constraints.Country;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author cbongiorno
 */
public class CountryCodeValidator extends AbstractConstraintValidator<Country,String> {

    private static final Set<String> VALID_CC = new HashSet<>(Arrays.asList(Locale.getISOCountries()));

    public CountryCodeValidator() {
        super((v,c) -> VALID_CC.contains(v));
    }
}
