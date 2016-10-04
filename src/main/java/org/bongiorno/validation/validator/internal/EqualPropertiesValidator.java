package org.bongiorno.validation.validator.internal;

import org.apache.commons.beanutils.PropertyUtils;
import org.bongiorno.validation.constraints.EqualProperties;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;

public class EqualPropertiesValidator implements
		ConstraintValidator<EqualProperties, Object> {

	private String[] properties;
	
	private boolean violationOnProperty;

	@Override
	public void initialize(EqualProperties constraint) {
		properties = constraint.value();
		if (properties == null || properties.length < 2) {
			throw new ValidationException("You have to define at least 2 properties");
			
		}
		
		violationOnProperty = constraint.violationOnProperty();
	}

	@Override
	public boolean isValid(Object bean,
			ConstraintValidatorContext context) {
		try {
			if (bean == null) {
				return true;

			}
			
			if (violationOnProperty) {
				context.disableDefaultConstraintViolation();
				
			}
			
			boolean valid = true;
			Object original = PropertyUtils.getSimpleProperty(bean, properties[0]);
			
			for (String property : properties) {
				Object copy = PropertyUtils.getSimpleProperty(bean, property);
				if (copy == null) {
					continue;
					
				}
				if (! copy.equals(original)) {
					valid = false;
					if (violationOnProperty) {
						context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
								.addPropertyNode(property)
								.addConstraintViolation();
						
					}
				}
			}
			return valid;
				
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new ValidationException(e);
			
		}
	}

}
