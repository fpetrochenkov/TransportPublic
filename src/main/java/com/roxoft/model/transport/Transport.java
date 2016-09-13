package com.roxoft.model.transport;

import com.roxoft.model.Driver;
import com.roxoft.model.Stops;

public abstract class Transport {

	private Integer id;
	private int number;
	private Driver driver;
	private Stops stop = new Stops();
	
	public Transport () {}
	
	public Transport (Integer id, int number, Driver driver, Stops stop) {
		this.id = id;
		this.number = number;
		this.driver = driver;
		this.stop = stop;
	}	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Stops getStop() {
		return stop;
	}

	public void setStop(Stops stop) {
		this.stop = stop;
	}





	
	
}
