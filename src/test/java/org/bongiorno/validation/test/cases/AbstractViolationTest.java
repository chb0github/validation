package org.bongiorno.validation.test.cases;

import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 */
@RunWith(Parameterized.class)
abstract public class AbstractViolationTest {
	
	private Object property;
	
	private Violation[] violations;
	
	protected AbstractBean<?> bean;

	public <T>AbstractViolationTest(Class<AbstractBean<T>> beanType, T property, Violation... violations) {
		try {
			AbstractBean<T> bean = beanType.newInstance();
			bean.setProperty(property);
			
			this.bean = bean;
			this.violations = violations;
			this.property = property;
			
		} catch (InstantiationException | IllegalAccessException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testViolation() {
		Locale.setDefault(Locale.ENGLISH);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		Set<?> constraintViolations = factory.getValidator().validate(bean);

		Assert.assertEquals(constraintViolations.size(), constraintViolations.size());
		
		Set<Violation> actualViolations = new HashSet<>();
		
		for (ConstraintViolation<Object> violation : (Set<ConstraintViolation<Object>>) constraintViolations) {
			testInvalidValue(violation);
			Assert.assertEquals(
					String.format("{%s.message}", violation.getConstraintDescriptor().getAnnotation().annotationType().getName()),
					violation.getMessageTemplate());
			
			actualViolations.add(new Violation(
					violation.getConstraintDescriptor().getAnnotation().annotationType(),
					violation.getMessage()));
		}
		
		Assert.assertEquals(
				String.format("%s was not invalid", property),
				new HashSet<>(Arrays.asList(violations)),
				actualViolations);
	}
	
	protected void testInvalidValue(ConstraintViolation<Object> violation) {
		Assert.assertEquals(property, violation.getInvalidValue());
	}

}
