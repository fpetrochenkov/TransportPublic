package com.roxoft.model.depos;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.transport.Tram;

public class TramDepo extends Depot {

	private List<Tram> trams = new ArrayList<Tram>();

	public TramDepo() {

	}

	public TramDepo(Integer id, String name, Address address) {
		super(id, name, address);
	}

	public List<Tram> getTrams() {
		return trams;
	}

	public void setTrams(List<Tram> trams) {
		this.trams = trams;
	}

	@Override
	public String toString() {
		return getName() + ": " + getAddress().toString() + "\nTrams: " + trams.toString();
	}

}
