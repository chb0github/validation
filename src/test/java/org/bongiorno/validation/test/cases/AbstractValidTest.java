package org.bongiorno.validation.test.cases;

import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 *
 */
@RunWith(Parameterized.class)
abstract public class AbstractValidTest {

	private AbstractBean<?> bean;

	public <T>AbstractValidTest(Class<AbstractBean<T>> beanType, T property) {
		try {
			AbstractBean<T> bean = beanType.newInstance();
			bean.setProperty(property);
			
			this.bean = bean;
			
		} catch (InstantiationException | IllegalAccessException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testValid() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<AbstractBean<?>>> violations = factory.getValidator().validate(bean);
		Assert.assertTrue(violations.toString(), violations.isEmpty());
	}

}
