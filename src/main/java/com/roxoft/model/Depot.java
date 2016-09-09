package com.roxoft.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.roxoft.dao.JDBC.BusDaoImpl;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Transport;
import com.roxoft.model.transport.Trolleybus;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Depo", propOrder = { "name", "address", "buses", "trolleybuses", "trams", "trains", "taxis" })
public class Depot {

	public Depot() {
	}

	
	
	private Integer id;
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonProperty
	@XmlElement(required = true)
	private String name;
	@JsonProperty
	@XmlElement(required = true)
	private Address address = new Address();
	@XmlElement(name = "bus")
	@XmlElementWrapper(name = "buses")
	@JsonProperty
	private List<Bus> buses;
	@XmlElement(name = "trolleybus")
	@XmlElementWrapper(name = "trolleybuses")
	@JsonProperty
	private List<Trolleybus> trolleybuses = new ArrayList<>();
	@XmlElement(name = "tram")
	@XmlElementWrapper(name = "trams")
	@JsonProperty
	private List<Tram> trams = new ArrayList<>();
	@XmlElement(name = "train")
	@XmlElementWrapper(name = "trains")
	@JsonProperty
	private List<Train> trains = new ArrayList<>();
	@XmlElement(name = "taxi")
	@XmlElementWrapper(name = "taxis")
	@JsonProperty
	private List<Taxi> taxis = new ArrayList<>();
	private List<Transport> transports = new ArrayList<Transport>();

	public Depot(Integer id, String name, Address address) {
		this.setId(id);
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void setBuses (List<Bus> buses) {
		this.buses = buses;
	}
	
	public void setTrolleybuses(List<Trolleybus> trolleybuses) {
		this.trolleybuses = trolleybuses;
	}

	public void setTrams(List<Tram> trams) {
		this.trams = trams;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public void setTaxis(List<Taxi> taxis) {
		this.taxis = taxis;
	}

	@Override
	public String toString() {
		return "\n" + name + ": " + "Address: " + address.toString() + transports.toString();
	}

	public List<Transport> getTransports() {
		return transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}

}
