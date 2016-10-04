package org.bongiorno.validation.test.cases.upload.uploadSize;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.bongiorno.validation.constraints.upload.UploadSize;
import org.bongiorno.validation.test.cases.AbstractValidTest;

/**
 *
 */
@Deprecated
/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@UploadSize(min=2, max=5)
		public MultipartFile getProperty() {
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
				{ Bean.class, new MockMultipartFile("file", new byte[]{}) },
				{ Bean.class, new MockMultipartFile("file", new byte[]{1, 2}) },
				{ Bean.class, new MockMultipartFile("file", new byte[]{1, 2, 3, 4, 5}) },
		});
	}

}