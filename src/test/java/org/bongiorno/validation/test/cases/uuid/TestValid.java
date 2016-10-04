package org.bongiorno.validation.test.cases.uuid;

import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Christian Bongiorno
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@org.bongiorno.validation.constraints.UUID
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
				{ Bean.class, UUID.randomUUID().toString() },
				{ Bean.class, UUID.randomUUID().toString().toLowerCase() },
				{ Bean.class, UUID.randomUUID().toString().toUpperCase() },
		});
	}

}
