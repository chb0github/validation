package org.bongiorno.validation.constraints.banking;

import org.bongiorno.validation.validator.internal.banking.bitcoin.BitcoinAddressValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The String must be a bitcoin address.
 *
 *
 * @see <a href="https://en.bitcoin.it/wiki/Address">https://en.bitcoin.it/wiki/Address</a>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy=BitcoinAddressValidatorForString.class)
@Documented
public @interface BitcoinAddress {

	String message() default "{org.bongiorno.validation.constraints.banking.BitcoinAddress.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link BitcoinAddress} annotations on the same element.
	 * 
	 * @see BitcoinAddress
	 */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
    	BitcoinAddress[] value();
	}
    
}