package org.bongiorno.validation.test.cases.age.adult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.age.Adult;
import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<LocalDate> {
		
		@Override
		@Adult
		public LocalDate getProperty() {
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
				{ Bean.class, LocalDate.now().minusYears(18) },
				{ Bean.class, LocalDate.now().minusYears(50) },
		});
	}

}