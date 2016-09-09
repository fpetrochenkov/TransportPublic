package com.roxoft.model.transport;

import java.util.List;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

@XmlType(name = "train", propOrder = { "number", "techDate", "cost", "driver" })

public class Train extends Transport {
	
	public Train() {}

	public Train(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nTrain: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: " + getStop();
	}

}
