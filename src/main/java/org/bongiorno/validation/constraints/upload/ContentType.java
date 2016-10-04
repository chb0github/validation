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

import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.validator.internal.upload.ContentTypeValidatorForMultipartFile;

/**
 * The MultipartFile must match a ContentType.
 * 
 * This constraint works only on Spring's {@link MultipartFile}.
 * You have to provide javax.mail for the matching.
 * 
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ContentTypeValidatorForMultipartFile.class)
@Documented
public @interface ContentType {

	String message() default "{org.bongiorno.validation.constraints.upload.ContentType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
    /**
	 * @return ContentType constraint
	 * @see javax.mail.internet.ContentType#match(String)
	 */
    String value();
    
    /**
	 * Defines several {@link ContentType} annotations on the same element.
	 * 
	 * @see ContentType
	 */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ContentType[] value();
	}
    
}
