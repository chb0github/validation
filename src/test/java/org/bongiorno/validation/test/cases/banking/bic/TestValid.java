package org.bongiorno.validation.test.cases.banking.bic;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.constraints.banking.BIC;
import org.bongiorno.validation.test.cases.AbstractValidTest;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@BIC
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, "RAIFCH22" },
		});
	}

}