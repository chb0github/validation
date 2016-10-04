package org.bongiorno.validation.test.cases.banking.bitcoin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.constraints.banking.BitcoinAddress;
import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@BitcoinAddress
		public String getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() throws IOException {
		Violation[] violations = new Violation[]{new Violation(BitcoinAddress.class, "The Bitcoin address is invalid.")};
		List<Object[]> cases = new ArrayList<>( Arrays.asList(new Object[][] {
				{ Bean.class, "xxx", violations },
				{ Bean.class, "", violations },
		}));
		
		try (InputStream stream
				= TestValid.class.getClassLoader().getResourceAsStream("bitcoin/base58_keys_invalid.json");
			 JsonReader jsonReader = Json.createReader(stream)) {
			
			JsonArray results = jsonReader.readArray();
			for (JsonArray tupel : results.getValuesAs(JsonArray.class)) {
				String address = tupel.getString(0);
				cases.add(new Object[]{ Bean.class, address, violations });
				
			}
		}
		
		return cases;
	}

}

