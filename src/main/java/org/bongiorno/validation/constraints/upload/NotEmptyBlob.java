package org.bongiorno.validation.constraints.upload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.sql.Blob;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bongiorno.validation.validator.internal.upload.NotEmptyBlobValidator;

/**
 * The {@link Blob} must not be empty.
 * 
 * Empty means it can be null, but it can't have the size of 0 bytes.
 * 
 *
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyBlobValidator.class)
@Documented
public @interface NotEmptyBlob {

	String message() default "{org.bongiorno.validation.constraints.upload.NotEmptyBlob.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
