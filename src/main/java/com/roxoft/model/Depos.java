package com.roxoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement (name = "Depos")
public class Depos {
	@JsonProperty ("Depo")
	@XmlElement(name = "Depo")
	private List<Depos> list = new ArrayList<>();

	public Depos() {
		super();
	}

	public void setList(List<Depos> list) {
		this.list = list;
	}

//	public boolean add(Depot depo) {
//		return list.addAll(depo);
//	}

	@Override
	public String toString() {
		return "Depos: " + "\n" +  list ;
	}

}
