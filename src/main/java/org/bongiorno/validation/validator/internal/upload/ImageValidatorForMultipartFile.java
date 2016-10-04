package org.bongiorno.validation.validator.internal.upload;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.constraints.upload.Image;

public class ImageValidatorForMultipartFile implements ConstraintValidator<Image, MultipartFile> {
	
	@Override
	public void initialize(Image constraintAnnotation) {
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		try {
			if (file == null || file.isEmpty()) {
				return true;
				
			}
			return ImageIO.read(file.getInputStream()) != null;
			
		} catch (IOException e) {
			throw new ValidationException(e);
			
		}
	}

}
