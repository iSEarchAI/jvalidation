package test.org.jvalidation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.jvalidation.Assertive.require;
import static org.jvalidation.Matchers.empty;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.jvalidation.Assertive;

public class AssertiveTest {
	
	@Test
	public void shouldThrowAnExceptionWhenInstantiateThisClass() {

		final Class<?> cls = Assertive.class;
		
		final Constructor<?> c = cls.getDeclaredConstructors()[0];
		
		c.setAccessible(true);

		assertThrows(InvocationTargetException.class, () -> {
			c.newInstance((Object[]) null);
		});
	}

	@Test
	public void shouldThrowAnExceptionWithNullIsProvidedAsMatcher() {

		assertThrows(NullPointerException.class, () -> {
			require(1, null);
		});
	}
	
	@Test
	public void shouldReturnTheTargetPassedAsParameter() {
		
		List<?> target = new ArrayList<>();
		List<?> output = require(target, empty());
		
		assertNotNull(output);
		assertTrue(target == output);
	}
}
