package com.roxoft.model.depos;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.transport.Bus;

public class BusDepo extends Depot {

	private List<Bus> buses = new ArrayList<Bus>();

	public BusDepo() {

	}

	public BusDepo(Integer id, String name, Address address) {
		super(id, name, address);
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return getName() + ": " + getAddress().toString() + "\nBuses: " + buses.toString();
	}

}
