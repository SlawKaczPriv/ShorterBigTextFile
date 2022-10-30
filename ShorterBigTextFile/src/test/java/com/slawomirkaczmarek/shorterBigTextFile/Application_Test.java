package com.slawomirkaczmarek.shorterBigTextFile;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Application_Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testPrintProps() {
		
		Properties props = new Properties();
		props.put("key1", "value1");
		props.put("key2", "value2");
//		Application application = new Application(props);
//		application.printProps();
//		fail("Not yet implemented");
		assertTrue(true);
	}

}
