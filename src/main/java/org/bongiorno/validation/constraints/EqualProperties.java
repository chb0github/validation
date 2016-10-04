package org.bongiorno.validation.constraints;

import org.bongiorno.validation.validator.internal.EqualPropertiesValidator;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The bean has properties with equal values.
 * 
 * Add this constraint at class level and name the property names
 * which have to be equal.
 * 
 * Properties which have Null values don't violate against this constraint.
 * Annotate those properties with {@link NotNull}.
 * 
 * Set {@link #violationOnProperty()} to true
 * if you want the {@link ConstraintViolation} on each of the violating
 * properties instead of the bean. 
 * 
 *
 * @since 0.1.0
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EqualPropertiesValidator.class)
@Documented
public @interface EqualProperties {

	String message() default "{org.bongiorno.validation.constraints.EqualProperties.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * property names (at least two) which have to have equal values.
	 */
	String[] value();
	
	/**
	 * Specifies whether the {@link ConstraintViolation} should be attached on each
	 * violation property or on the bean. By default on the bean.
	 * 
	 * @return {@code true} if the violation should be attached on each violating property,
	 *         {@code false} if it should be attached on the bean.
	 */
	boolean violationOnProperty() default false;

	/**
	 * Defines several {@link EqualProperties} annotations on the same element.
	 * 
	 * @see EqualProperties
	 */
	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EqualProperties[] value();
	}

}