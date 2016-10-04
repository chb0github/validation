package org.bongiorno.validation.constraints.net;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bongiorno.validation.validator.internal.net.TLDValidatorForString;

/**
 * The String is a Top Level Domain.
 * 
 *
 */
@Constraint(validatedBy={ TLDValidatorForString.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface TLD {

	static public enum TLDType {
		INFRASTRUCTURE,
		LOCAL,
		GENERIC,
		COUNTRY
	}
	
	String message() default "{org.bongiorno.validation.constraints.net.TLD.message}";
	
	/**
	 * @return List of valid TLD types. Default is all except {@link TLDType#LOCAL}
	 */
	TLDType[] value() default {
		TLDType.INFRASTRUCTURE,
		TLDType.GENERIC,
		TLDType.COUNTRY };

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link TLD} annotations on the same element.
	 * 
	 * @see TLD
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		TLD[] value();
	}
}
