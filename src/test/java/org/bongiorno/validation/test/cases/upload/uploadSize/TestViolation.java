package org.bongiorno.validation.test.cases.upload.uploadSize;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.constraints.upload.UploadSize;
import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
@Deprecated
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@UploadSize(min=2, max=5)
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
				new Violation(UploadSize.class, "The uploaded file size must be between 2 and 5 bytes.") };
		return Arrays.asList(new Object[][] {
				{ Bean.class, new MockMultipartFile("image", new byte[] {1}), violations },
				{ Bean.class, new MockMultipartFile("image", new byte[] {1, 2, 3, 4, 5, 6}), violations },
		});
	}

}