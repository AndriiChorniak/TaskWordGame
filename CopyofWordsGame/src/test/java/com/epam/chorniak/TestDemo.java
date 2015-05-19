package com.epam.chorniak;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Before;
import org.junit.Test;


import com.epam.factory.*;


public class TestDemo {
	AbstractCitiesBuilder citiesBuilder;
	
	@Before
	public void init(){
		citiesBuilder = new XMLCitiesBuilder();	
	}
	
	@Test
	public void testList(){
		List<String> actual = citiesBuilder.reader();
		assertNotNull(actual);
	}
	
	
	

}
