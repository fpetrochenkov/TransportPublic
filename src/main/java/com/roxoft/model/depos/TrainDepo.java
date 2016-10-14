package com.roxoft.model.depos;

import java.util.ArrayList;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.transport.Train;

public class TrainDepo extends Depot {

	private List<Train> trains = new ArrayList<Train>();

	public TrainDepo() {

	}

	public TrainDepo(Integer id, String name, Address address) {
		super(id, name, address);
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	@Override
	public String toString() {
		return getName() + ": " + getAddress().toString() + "\nTrains: " + trains.toString();
	}

}
