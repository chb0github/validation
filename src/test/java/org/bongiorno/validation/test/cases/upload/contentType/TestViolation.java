package org.bongiorno.validation.test.cases.upload.contentType;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.upload.ContentType;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@ContentType("image/*")
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
		Violation[] violations = new Violation[]{new Violation(ContentType.class, "The uploaded file must match the content type \"image/*\".")};
		return Arrays.asList(new Object[][] {
				{ Bean.class, new MockMultipartFile("file", "file", "text/html", new byte[]{1}), violations },
		});
	}

}

