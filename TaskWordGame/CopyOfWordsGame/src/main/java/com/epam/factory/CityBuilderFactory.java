package com.epam.factory;

public class CityBuilderFactory {
	private enum TypeDB {
		JSON, TXT, EXCEL, XML
	}

	public AbstractCitiesBuilder createCitiesBuilder(String typeDB) {
		TypeDB type = TypeDB.valueOf(typeDB.toUpperCase());
		switch (type) {
		case JSON:
			return new JSONCitiesBuilder();
		case TXT:
			return new TXTCitiesBuilder();
		case EXCEL:
			return new EXCELCitiesBuilder();
		case XML:
			return new XMLCitiesBuilder();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(),
					type.name());
		}
	}

}
