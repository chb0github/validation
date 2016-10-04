package org.bongiorno.validation.test.cases.net.tld;

import java.util.Arrays;
import java.util.List;

import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.constraints.net.TLD;
import org.bongiorno.validation.constraints.net.TLD.TLDType;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class InfrastructureBean extends AbstractBean<String> {
		
		@Override
		@TLD(TLDType.INFRASTRUCTURE)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class GenericBean extends AbstractBean<String> {
		
		@Override
		@TLD(TLDType.GENERIC)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class CountryBean extends AbstractBean<String> {
		
		@Override
		@TLD(TLDType.COUNTRY)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class LocalBean extends AbstractBean<String> {
		
		@Override
		@TLD(TLDType.LOCAL)
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@TLD
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
				{ Bean.class, "de" },
				{ Bean.class, "org" },
				{ Bean.class, "net" },
				{ Bean.class, "arpa" },
				{ Bean.class, "aero" },
				{ LocalBean.class, null },
				{ LocalBean.class, "localhost" },
				{ CountryBean.class, null },
				{ CountryBean.class, "de" },
				{ GenericBean.class, null },
				{ GenericBean.class, "net" },
				{ InfrastructureBean.class, null },
				{ InfrastructureBean.class, "arpa" },
		});
	}

}
