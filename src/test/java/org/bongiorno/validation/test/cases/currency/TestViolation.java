package org.bongiorno.validation.test.cases.currency;

import org.bongiorno.validation.constraints.CurrencyCode;
import org.bongiorno.validation.test.cases.AbstractViolationTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

/**
 * @author Christian Bongiorno
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@CurrencyCode
		public String getProperty() {
			return super.getProperty();
		}
		
	}

	public <T> TestViolation(Class<AbstractBean<T>> beanType, T property,
                             Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {

		Violation[] violations = new Violation[]{new Violation(CurrencyCode.class)};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "foo", violations },
		});
	}

}
