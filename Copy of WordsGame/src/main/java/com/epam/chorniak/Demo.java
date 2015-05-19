package com.epam.chorniak;



import org.apache.log4j.Logger;

import com.epam.factory.AbstractCitiesBuilder;
import com.epam.factory.CityBuilderFactory;

public class Demo {
	
	private static final Logger LOG = Logger.getLogger(Demo.class);

	public static void main(String[] args) {
		String typeDB = "EXCEL"; // TXT, JSON, XML 
		LOG.info("Main method start. Type of DB: " + typeDB);
		CityBuilderFactory factory = new CityBuilderFactory();
		AbstractCitiesBuilder citiesBuilder = factory.createCitiesBuilder(typeDB);
		LOG.info("Builder has been created!");
		Game game = new Game(citiesBuilder.reader()); 
		game.start();
		LOG.info("Exit from main method");
	}

}
