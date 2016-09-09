package com.roxoft.model.transport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bus", propOrder = { "number", "techDate", "cost", "driver" })
public class Bus extends Transport {
	
	public Bus () {}

	public Bus(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nBus: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: " + getStop();
	}

}
