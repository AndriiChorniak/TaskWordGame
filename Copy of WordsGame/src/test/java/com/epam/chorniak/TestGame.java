package com.epam.chorniak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.factory.AbstractCitiesBuilder;
import com.epam.factory.XMLCitiesBuilder;

public class TestGame {
	Game game = null;
	AbstractCitiesBuilder a = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 a = new XMLCitiesBuilder();
		 game = new Game(a.reader());
	}

	@After
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
	

}
