package com.roxoft.model;

public class Stops {

	public Stops() {
	}

	private Integer id;
	private Address from = new Address();
	private Address to = new Address();

	public Stops(Integer id, Address from, Address to) {
		this.id = id;
		this.from = from;
		this.to = to;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return from.toString() + " - " + to.toString();
	}

}
