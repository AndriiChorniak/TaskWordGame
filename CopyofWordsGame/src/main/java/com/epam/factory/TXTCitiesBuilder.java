package com.epam.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TXTCitiesBuilder extends AbstractCitiesBuilder {

	@Override
	public List<String> reader() {
		File file = new File("src\\main\\resources\\cities.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			String line = null;

			while ((line = br.readLine()) != null) {
				cities.add(line.toLowerCase());

			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cities;
	}

}
