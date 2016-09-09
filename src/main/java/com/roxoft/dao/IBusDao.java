package com.roxoft.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.exceptions.IncorrectIdException;
import com.roxoft.exceptions.IncorrectInputException;
import com.roxoft.model.transport.Bus;

public interface IBusDao <E,K>{

	public void create(Bus entity) throws SQLException;
	public Bus read(int key) throws SQLException;		
	public List<Bus> getAll() throws SQLException;
	
	
}
