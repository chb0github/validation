package org.bongiorno.validation.validator.internal.upload;

import javax.mail.internet.ParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bongiorno.validation.constraints.upload.ContentType;
import org.springframework.web.multipart.MultipartFile;

public class ContentTypeValidatorForMultipartFile implements ConstraintValidator<ContentType, MultipartFile> {
	
	private javax.mail.internet.ContentType contentType;

	@Override
	public void initialize(ContentType constraintAnnotation) {
		try {
			contentType = new javax.mail.internet.ContentType(constraintAnnotation.value());
			
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
			
		}
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		if (file == null || file.isEmpty()) {
			return true;
			
		}
		return contentType.match(file.getContentType());
	}

}
