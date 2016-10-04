package org.bongiorno.validation.test.cases.equalProperties;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.bongiorno.validation.constraints.EqualProperties;
import org.bongiorno.validation.test.cases.AbstractViolationTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.Assert;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	static final private String originalValue = "originalValue";

	@EqualProperties({"original", "original", "property"})
	public static class ThreePropertiesBean extends Bean {
		
	}
	
	@EqualProperties({"original", "property"})
	public static class Bean extends AbstractBean<String> {
		
		private String original = originalValue;
		
		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(EqualProperties.class, "The properties are not equal.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
				{ ThreePropertiesBean.class, "xxx", violations },
				{ ThreePropertiesBean.class, "", violations },
		});
	}
	
	@Override
	protected void testInvalidValue(ConstraintViolation<Object> violation) {
		Assert.assertEquals(bean, violation.getInvalidValue());
	}

}
