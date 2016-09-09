package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.model.transport.Taxi;

public interface ITaxiDao <E,K>{

	
	public void create(Taxi entity) throws SQLException;
	public Taxi read(int key) throws SQLException;		
	public List<Taxi> getAll() throws SQLException, DataNotFoundException;
}
