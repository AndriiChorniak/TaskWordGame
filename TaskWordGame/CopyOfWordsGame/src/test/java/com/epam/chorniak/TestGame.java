package com.epam.chorniak;

//import static org.junit.Assert.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.io.BufferedReader;
import java.util.Scanner;

import org.testng.annotations.*;

import static org.easymock.EasyMock.*;

import com.epam.factory.AbstractCitiesBuilder;
import com.epam.factory.XMLCitiesBuilder;

public class TestGame {
	BufferedReader mock;
	Game game = null;
	AbstractCitiesBuilder a = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeMethod
	public void setUp() throws Exception {
		 a = new XMLCitiesBuilder();
		 game = new Game(a.reader());
		// mock = createMock(BufferedReader.class);
	}

	@AfterMethod
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateList() {
		
		assertNotNull(game.getCities());
	}
	@Test
	public void testListSame(){
		assertEquals(a.reader(), game.getCities());
	}
	
	@Test
	public void testInit() throws Exception{
//		expect(mock.readLine()).andReturn("3");
//		replay(mock);
//		
//		game.init();
//		assertNotNull(game.getUsers());
//		
//		verify(mock);
		
	}
	

}
