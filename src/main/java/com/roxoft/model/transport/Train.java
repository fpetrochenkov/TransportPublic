package com.roxoft.model.transport;

import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

public class Train extends Transport {

	public Train() {
	}

	public Train(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nTrain: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: "
				+ getStop();
	}

}
