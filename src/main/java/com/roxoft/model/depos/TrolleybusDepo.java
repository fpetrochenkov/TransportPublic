package com.roxoft.model.depos;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.transport.Trolleybus;

public class TrolleybusDepo extends Depot {
	
	private List<Trolleybus> trolleys = new ArrayList<Trolleybus>();
	
	public TrolleybusDepo(){
		
	}

	public TrolleybusDepo(Integer id, String name, Address address) {
		super(id, name, address);
	}	

	public List<Trolleybus> getTrolleys() {
		return trolleys;
	}

	public void setTrolleys(List<Trolleybus> trolleys) {
		this.trolleys = trolleys;
	}
	
	@Override
	public String toString(){
		return getName() + ": " + getAddress().toString() + "\nTrolleybuses: " + trolleys.toString();
	}

}
