package org.bongiorno.validation.test.cases.banking.iban;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.constraints.banking.IBAN;
import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@IBAN
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
		Violation[] violations = new Violation[]{new Violation(IBAN.class, "The IBAN address is invalid.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
		});
	}

}

