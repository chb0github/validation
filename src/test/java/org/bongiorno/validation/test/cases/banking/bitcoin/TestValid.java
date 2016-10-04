package org.bongiorno.validation.test.cases.banking.bitcoin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.constraints.banking.BitcoinAddress;
import org.bongiorno.validation.test.cases.AbstractValidTest;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<String> {
		
		@Override
		@BitcoinAddress
		public String getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() throws IOException {
		List<Object[]> cases = new ArrayList<>(Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, "1335STSwu9hST4vcMRppEPgENMHD2r1REK" },
		}));

		try (InputStream stream
					= TestValid.class.getClassLoader().getResourceAsStream("bitcoin/base58_keys_valid.json");
			 JsonReader jsonReader = Json.createReader(stream)) {
				
			JsonArray results = jsonReader.readArray();
			for (JsonArray tupel : results.getValuesAs(JsonArray.class)) {
				String address = tupel.getString(0);
				JsonObject meta = tupel.getJsonObject(2);
				if (! meta.containsKey("addrType")) {
					continue;
					
				}
				if (! "pubkey".equals(meta.getString("addrType"))) {
					continue;
					
				}
				if (meta.getBoolean("isTestnet")) {
					continue;
					
				}
				cases.add(new Object[]{ Bean.class, address });
			
			}
		}
		return cases;
	}

}
