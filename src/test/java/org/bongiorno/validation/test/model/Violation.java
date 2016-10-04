package org.bongiorno.validation.test.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class Violation {


	private static final Properties MESSAGES = new Properties();
	static {
		try {
			MESSAGES.load(Violation.class.getResourceAsStream("/ValidationMessages.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String message;

	private Class<? extends Annotation> constraint;

	public Violation(Class<? extends Annotation> constraint, String message) {
		this.constraint = constraint;
		this.message = message;
	}

	public Violation(Class<? extends Annotation> constraint) {
		this.constraint = constraint;
		this.message = MESSAGES.getProperty(constraint.getName() + ".message");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Class<? extends Annotation> getConstraint() {
		return constraint;
	}

	public void setConstraint(Class<? extends Annotation> constraint) {
		this.constraint = constraint;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return "Violation{" +
				"message='" + message + '\'' +
				", constraint=" + constraint +
				'}';
	}
}
