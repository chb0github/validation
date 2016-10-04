package org.bongiorno.validation.constraints.upload;

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

import org.bongiorno.validation.validator.internal.upload.NotEmptyUploadValidatorForMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * The MultipartFile must not be empty.
 * 
 * This constraint works only on Spring's {@link MultipartFile}.
 * 
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = NotEmptyUploadValidatorForMultipartFile.class)
@Documented
public @interface NotEmptyUpload {

	String message() default "{org.bongiorno.validation.constraints.upload.NotEmptyUpload.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    /**
	 * Defines several {@link NotEmptyUpload} annotations on the same element.
	 * 
	 * @see NotEmptyUpload
	 */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		NotEmptyUpload[] value();
	}
	
}
