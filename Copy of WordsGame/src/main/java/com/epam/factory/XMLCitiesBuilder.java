package com.epam.factory;



import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class XMLCitiesBuilder extends AbstractCitiesBuilder {
	
	public List<String> reader() {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			DefaultHandler defaultHandler = new DefaultHandler() {
				boolean bcity = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equalsIgnoreCase("City")) {
						bcity = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (bcity) {
						cities.add(new String(ch, start, length).toLowerCase());
						bcity = false;

					}
				}
			};
			saxParser.parse("src\\main\\resources\\cities.xml", defaultHandler);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return cities;

	}
}