package org.bongiorno.validation.test.cases.upload.size;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Size;

import org.bongiorno.validation.test.cases.AbstractViolationTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@Size(min=2, max=5)
		public MultipartFile getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation[] violations = new Violation[]{
				new Violation(Size.class, "size must be between 2 and 5") };
		return Arrays.asList(new Object[][] {
				{ Bean.class, new MockMultipartFile("image", new byte[] {1}), violations },
				{ Bean.class, new MockMultipartFile("image", new byte[] {1, 2, 3, 4, 5, 6}), violations },
		});
	}

}
