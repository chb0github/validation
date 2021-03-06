package org.bongiorno.validation.test.cases.upload.notEmptyUpload;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.constraints.upload.NotEmptyUpload;
import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@NotEmptyUpload
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
				{ Bean.class, new MockMultipartFile("file", new byte[]{1}) },
		});
	}

}