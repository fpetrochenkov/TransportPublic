package com.roxoft.model;

public class Address {
	private Integer id;
	private String street;
	private int houseNumber;

	public Address() {
	}

	public Address(Integer id, String street, int houseNumber) {
		this.id = id;
		this.street = street;
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return street + ", " + houseNumber;
	}

}
