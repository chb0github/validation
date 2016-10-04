package org.bongiorno.validation.constraints.net;

import org.bongiorno.validation.validator.internal.net.DomainValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The String has to be a Domain.
 * 
 *
 */
@Constraint(validatedBy={DomainValidatorForString.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Domain {

	String message() default "{org.bongiorno.validation.constraints.net.Domain.message}";
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link Domain} annotations on the same element.
	 * 
	 * @see Domain
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Domain[] value();
	}
}
