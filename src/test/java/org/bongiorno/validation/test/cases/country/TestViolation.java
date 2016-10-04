package org.bongiorno.validation.test.cases.country;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.Country;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@Country
		public String getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(Country.class, "The country code is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
				{ Bean.class, "x", violations },
				{ Bean.class, "X1", violations },
				{ Bean.class, "de", violations },
		});
	}

}
