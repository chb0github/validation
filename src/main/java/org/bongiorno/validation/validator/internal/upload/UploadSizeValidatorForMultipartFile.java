package org.bongiorno.validation.validator.internal.upload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bongiorno.validation.constraints.upload.UploadSize;
import org.bongiorno.validation.validator.jsr349.size.SizeValidatorForMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @deprecated use {@link SizeValidatorForMultipartFile}.
 * @author malkusch
 */
@Deprecated
public class UploadSizeValidatorForMultipartFile implements ConstraintValidator<UploadSize, MultipartFile> {
	
	private long min;
	
	private long max;

	@Override
	public void initialize(UploadSize constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		if (file == null || file.isEmpty()) {
			return true;
			
		}
		long size = file.getSize();
		return min <= size && size <= max;
	}

}
