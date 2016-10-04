package org.bongiorno.validation.validator.internal.upload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.constraints.upload.NotEmptyUpload;

public class NotEmptyUploadValidatorForMultipartFile implements ConstraintValidator<NotEmptyUpload, MultipartFile> {

	@Override
	public void initialize(NotEmptyUpload constraintAnnotation) {
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		return file != null && ! file.isEmpty();
	}

}
