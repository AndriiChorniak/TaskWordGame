package com.epam.factory;

import java.util.*;

public abstract class AbstractCitiesBuilder {
	protected List<String> cities = new ArrayList<String>();

	public abstract List<String> reader();

}
