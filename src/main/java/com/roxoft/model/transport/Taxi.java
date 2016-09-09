package com.roxoft.model.transport;

import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

public class Taxi extends Transport{
	
	public Taxi () {}

	public Taxi(Integer id, int number, Driver driver, Stops stop) {
		super(id, number, driver, stop);
	}

	@Override
	public String toString() {
		return "\nTaxi: " + "number: " + getNumber() + ", " + " Driver: " + getDriver().toString() + "; Route: " + getStop();
	}
	

	
}
