package com.roxoft.model.depos;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.transport.Taxi;

public class TaxiStation extends Depot {

	private List<Taxi> taxis = new ArrayList<Taxi>();

	public TaxiStation() {

	}

	public TaxiStation(Integer id, String name, Address address) {
		super(id, name, address);
	}

	public List<Taxi> getTaxis() {
		return taxis;
	}

	public void setTaxis(List<Taxi> taxis) {
		this.taxis = taxis;
	}

	@Override
	public String toString() {
		return getName() + ": " + getAddress().toString() + "\nTaxis: " + taxis.toString();
	}
}
