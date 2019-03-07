package org.jvalidation;

import org.jvalidation.matcher.number.IntegerMatcher;
import org.jvalidation.matcher.object.ObjectMatcher;

public class Assertive {
	
	protected Object object;

	public Assertive(Object object) {
		this.object = object;
	}

	public static Assertive require(Object object) {
		return new Assertive(object);
	}

	public IntegerMatcher isInteger() {

		if (!(object instanceof Integer)) {
			throw new IllegalArgumentException("The value is not an integer");
		}

		return new IntegerMatcher((int) object);
	}
	
	public ObjectMatcher isObject() {
		return new ObjectMatcher(object);
	}
}
