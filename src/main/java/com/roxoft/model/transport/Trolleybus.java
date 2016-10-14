package com.roxoft.model.transport;

import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

public class Trolleybus extends Transport {

	public Trolleybus() {
	}

	public Trolleybus(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nTrolleybus: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: "
				+ getStop();
	}

}
