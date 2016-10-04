package org.bongiorno.validation.test.cases.net.domain;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.net.Domain;
import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@Domain
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
				{ Bean.class, "malkusch.de" },
				{ Bean.class, "www.malkusch.de" },
				{ Bean.class, "malkusch.org" },
				{ Bean.class, "malkusch.net" },
				{ Bean.class, "malkusch.arpa" },
				{ Bean.class, "malkusch.aero" },
		});
	}

}
