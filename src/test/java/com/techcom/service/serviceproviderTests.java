package com.techcom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
public class serviceproviderTests {

	@Autowired
	private serviceprovider serviceProvider;
	
	@Test
	public void testgetuser() {
		assertNotNull(serviceProvider.getuser("thakur00000@gmail.com"));
	}
	
	@ParameterizedTest
	@CsvSource({ "1,1" })
	public void testsum(int a, int b) {
		assertEquals(a,b );
		assertTrue(true);
	}
}
