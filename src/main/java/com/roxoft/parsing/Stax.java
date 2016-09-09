package com.roxoft.parsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.roxoft.model.Address;
import com.roxoft.model.Depot;
import com.roxoft.model.Driver;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Trolleybus;

import java.util.ArrayList;

public class Stax {

	public void parser() throws XMLStreamException, FileNotFoundException {

		boolean bCity = false;
		boolean bStreet = false;
		boolean bZipCode = false;
		boolean bHouseNum = false;
		boolean bName = false;
		boolean bFirstName = false;
		boolean bLastName = false;
		boolean bCategory = false;
		boolean bExpirience = false;
		boolean bNumber = false;
		boolean bTechDate = false;
		boolean bCost = false;

		ArrayList<Depot> depos = null;
		Depot depo = null;
		ArrayList<Driver> drivers = null;
		Driver driver = null;
		ArrayList<Address> addresses = null;
		Address address = null;
		ArrayList<Bus> buses = null;
		Bus bus = null;
		ArrayList<Trolleybus> trolleys = null;
		Trolleybus trolley = null;
		ArrayList<Tram> trams = null;
		Tram tram = null;
		ArrayList<Train> trains = null;
		Train train = null;
		ArrayList<Taxi> taxis = null;
		Taxi taxi = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("src/main/resources/Transport.xml"));
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
//					StartElement startElement = event.asStartElement();
//					String qName = startElement.getName().getLocalPart();
//					if (qName.equalsIgnoreCase("Depo")) {
//						depo = new Depot(null, null, null);
//						Iterator<Attribute> attributes = startElement.getAttributes();						
//					} else if (qName.equalsIgnoreCase("Address")) {
//						address = new Address(null, null, null, 0);
//						System.out.print("Address: ");
//					} else if (qName.equalsIgnoreCase("Buses")) {
//						buses = new ArrayList<Bus>();
//						System.out.println("Buses: ");
////					} else if (qName.equalsIgnoreCase("Bus")) {
////						bus = new Bus(0, null, 0, null);
////						buses.add(bus);
////						System.out.print("Bus: ");						
////					} else if (qName.equalsIgnoreCase("Trolleybuses")) {
////						trolleys = new ArrayList<Trolleybus>();
////						System.out.println("Trolleybuses: ");
////					} else if (qName.equalsIgnoreCase("Trolleybus")) {
////						trolley = new Trolleybus(0, null, 0, null);
////						trolleys.add(trolley);
////						System.out.print("Trolley: ");						
////					} else if (qName.equalsIgnoreCase("Trams")) {
////						trams = new ArrayList<Tram>();
////						System.out.println("Trams: ");
////					} else if (qName.equalsIgnoreCase("Tram")) {
////						tram = new Tram(0, null, 0, null);
////						trams.add(tram);
////						System.out.print("Tram: ");						
////					} else if (qName.equalsIgnoreCase("Trains")) {
////						trains = new ArrayList<Train>();
////						System.out.println("Trains: ");
////					} else if (qName.equalsIgnoreCase("Train")) {
////						train = new Train(0, null, 0, null);
////						trains.add(train);
////						System.out.print("Train: ");						
////					} else if (qName.equalsIgnoreCase("Taxis")) {
////						taxis = new ArrayList<Taxi>();
////						System.out.println("Taxis: ");
////					} else if (qName.equalsIgnoreCase("Taxi")) {
////						taxi = new Taxi(0, null, 0, null);
////						taxis.add(taxi);
////						System.out.print("Taxi: ");										
//					} else if (qName.equalsIgnoreCase("Driver")) {
//						driver = new Drivers(null, null, null, null, 0);
//						System.out.print("Driver: ");						
//					} else if (qName.equalsIgnoreCase("firstname")) {
//						bFirstName = true;
//					} else if (qName.equalsIgnoreCase("lastname")) {
//						bLastName = true;
//					} else if (qName.equalsIgnoreCase("expirience")) {
//						bExpirience = true;
//					} else if (qName.equalsIgnoreCase("category")) {
//						bCategory = true;
//					} else if (qName.equalsIgnoreCase("city")) {
//						bCity = true;
//					} else if (qName.equalsIgnoreCase("street")) {
//						bStreet = true;
//					} else if (qName.equalsIgnoreCase("zipCode")) {
//						bZipCode = true;
//					} else if (qName.equalsIgnoreCase("houseNumber")) {
//						bHouseNum = true;
//					} else if (qName.equalsIgnoreCase("number")) {
//						bNumber = true;
//					} else if (qName.equalsIgnoreCase("techDate")) {
//						bTechDate = true;
//					} else if (qName.equalsIgnoreCase("cost")) {
//						bCost = true;
//					}
//
//					break;
//
//				case XMLStreamConstants.CHARACTERS:
//					Characters characters = event.asCharacters();
//					if (bFirstName) {
//						driver.setFirstname(characters.getData());
//						System.out.print(characters.getData() + " ");
//						bFirstName = false;
//					}
//					if (bLastName) {
//						driver.setLastname(characters.getData());
//						System.out.print(characters.getData() + " ");
//						bLastName = false;
//					}
//					if (bCategory) {
//						driver.setCategory(characters.getData());
//						System.out.print("category " + characters.getData() + " ");
//						bCategory = false;
//					}
//					if (bExpirience) {
//						driver.setExpirience(Double.parseDouble(characters.getData()));
//						System.out.println("expirience " + characters.getData());
//						bExpirience = false;
//					}
//					if (bCity) {
//						address.setCity(characters.getData());
//						System.out.print(characters.getData() + ", ");
//						bCity = false;
//					}
//					if (bStreet) {
//						address.setStreet(characters.getData());
//						System.out.print(characters.getData() + ", ");
//						bStreet = false;
//					}
//					if (bZipCode) {
//						address.setZipCode(characters.getData());
//						System.out.print(characters.getData());
//						bZipCode = false;
//					}
//					if (bHouseNum) {
//						address.setHouseNumber(Integer.parseInt(characters.getData()));
//						System.out.println(", " + characters.getData());
//						bHouseNum = false;
//					}
//					if (bNumber) {
//						bus.setNumber(Integer.parseInt(characters.getData()));
//						System.out.print("Number " + characters.getData() + ", ");
////						bNumber = false;
////					}
//					if (bTechDate) {
//						bus.setTechDate(characters.getData());
//						System.out.print("Tech Date: " + characters.getData() + ", ");
//						bTechDate = false;
//					}
//					if (bCost) {
//						bus.setCost(Integer.parseInt(characters.getData()));
//						System.out.println("Cost: " + characters.getData());
//						bCost = false;
//					}
//					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equalsIgnoreCase("Address")) {
						depo.setAddress(address);

					}
					if (endElement.getName().getLocalPart().equalsIgnoreCase("Driver")) {
						bus.setDriver(driver);						
						

					}
					if (endElement.getName().getLocalPart().equalsIgnoreCase("Bus")) {
						buses.add(bus);
					}

					break;
				}
			}
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
