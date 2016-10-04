package org.bongiorno.validation.test.cases.isbn;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.ISBN;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
                            Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{new Violation(ISBN.class, "The ISBN is invalid.")};
		return Arrays.asList(new Object[][] {
				{ TestValid.Bean.class, "", violations },
				{ TestValid.Bean.class, "xx", violations },
				{ TestValid.ISBN10Bean.class, "", violations },
				{ TestValid.ISBN10Bean.class, "xx", violations },
				{ TestValid.ISBN10Bean.class, "9780672327568", violations },
				{ TestValid.ISBN13Bean.class, "", violations },
				{ TestValid.ISBN13Bean.class, "xx", violations },
				{ TestValid.ISBN13Bean.class, "0-306-40615-2", violations },
		});
	}

}
