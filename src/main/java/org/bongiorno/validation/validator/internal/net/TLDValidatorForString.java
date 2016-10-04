package org.bongiorno.validation.validator.internal.net;

import org.apache.commons.validator.routines.DomainValidator;
import org.bongiorno.validation.constraints.net.TLD;
import org.bongiorno.validation.constraints.net.TLD.TLDType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class TLDValidatorForString implements ConstraintValidator<TLD, String> {

    private Set<TLDType> types;

    @Override
    public void initialize(TLD constraint) {
        types = new HashSet<>(Arrays.asList(constraint.value()));
    }

    @Override
    public boolean isValid(String tld, ConstraintValidatorContext context) {

        if (tld == null) {
            return true;

        }
        DomainValidator v = DomainValidator.getInstance();
        Predicate<String> p = v::isValidCountryCodeTld;
        p.or(v::isValidGenericTld).or(v::isValidInfrastructureTld).or(v::isValidLocalTld);

        if (types.contains(TLDType.COUNTRY)) {
            if (v.isValidCountryCodeTld(tld)) {
                return true;

            }
        }
        if (types.contains(TLDType.GENERIC)) {
            if (v.isValidGenericTld(tld)) {
                return true;

            }
        }
        if (types.contains(TLDType.INFRASTRUCTURE)) {
            if (v.isValidInfrastructureTld(tld)) {
                return true;

            }
        }
        if (types.contains(TLDType.LOCAL)) {
            if (v.isValidLocalTld(tld)) {
                return true;

            }
        }
        return false;
    }

}
