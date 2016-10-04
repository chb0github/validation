package org.bongiorno.validation.test.model;

public class AbstractBean<T> {

	private T property;

	public T getProperty() {
		return property;
	}

	public void setProperty(T property) {
		this.property = property;
	}
	
}
