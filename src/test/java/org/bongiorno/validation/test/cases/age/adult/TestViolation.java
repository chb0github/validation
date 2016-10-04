package org.bongiorno.validation.test.cases.age.adult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.age.Adult;
import org.bongiorno.validation.constraints.age.Age;
import org.bongiorno.validation.test.cases.AbstractViolationTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<LocalDate> {
		
		@Override
		@Adult
		public LocalDate getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(Age.class, "The Age must be at least 18 years.")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, LocalDate.now().minusDays(1), violations },
				{ Bean.class, LocalDate.now().minusYears(18).plusDays(1), violations },
		});
	}

}