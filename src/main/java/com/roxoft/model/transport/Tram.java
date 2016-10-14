package com.roxoft.model.transport;

import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

public class Tram extends Transport {

	public Tram() {
	}

	public Tram(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nTram: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: "
				+ getStop();
	}

}
