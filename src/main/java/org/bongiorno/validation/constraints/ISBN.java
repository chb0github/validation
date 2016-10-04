package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.internal.ISBNValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The String has to be an ISBN.
 * 
 *
 */
@Constraint(validatedBy={ISBNValidatorForString.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface ISBN {
	
	/**
	 * ISBN type.
	 * 
	 *
	 */
	static public enum Type {
		/**
		 * ISBN-13
		 */
		ISBN10,
		
		/**
		 * ISBN-10
		 */
		ISBN13,
	}

	/**
	 * @return List of valid ISBN types. Default is all.
	 */
	Type[] value() default { Type.ISBN10, Type.ISBN13 };
	
	String message() default "{org.bongiorno.validation.constraints.ISBN.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * Defines several {@link ISBN} annotations on the same element.
	 * 
	 * @see ISBN
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ISBN[] value();
	}
}
