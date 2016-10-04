package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.CountryCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The String has to be a well formed ISO-3166-1 alpha-2 country code.
 * 
 * Those codes are upper case.
 * 
 *
 */
@Constraint(validatedBy= CountryCodeValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Documented
public @interface Country {

	String message() default "{org.bongiorno.validation.constraints.Country.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link Country} annotations on the same element.
	 * 
	 * @see Country
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Country[] value();
	}
}
