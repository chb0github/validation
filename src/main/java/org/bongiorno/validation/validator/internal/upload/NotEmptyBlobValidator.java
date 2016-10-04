package org.bongiorno.validation.validator.internal.upload;

import java.sql.Blob;
import java.sql.SQLException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.bongiorno.validation.constraints.upload.NotEmptyBlob;

public class NotEmptyBlobValidator implements ConstraintValidator<NotEmptyBlob, Blob> {

	@Override
	public void initialize(NotEmptyBlob constraintAnnotation) {
	}

	@Override
	public boolean isValid(Blob blob,
			ConstraintValidatorContext context) {
		
		try {
			if (blob == null) {
				return true;
				
			}
			return blob.length() > 0;
			
		} catch (SQLException e) {
			throw new ValidationException(e);
			
		}
	}

}
