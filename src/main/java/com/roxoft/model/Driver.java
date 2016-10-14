package com.roxoft.model;

public class Driver {
	private Integer id;
	private String firstName;
	private String lastName;
	private Address address = new Address();

	public Driver() {
	}

	public Driver(Integer id, String firstName, String lastName, Address address) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n" + firstName + " " + lastName + "; " + " Drivers address: " + address.toString();
	}

}