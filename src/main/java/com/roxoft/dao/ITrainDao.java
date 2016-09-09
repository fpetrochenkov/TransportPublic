package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.model.transport.Train;

public interface ITrainDao <E,K>{

	
	public void create(Train entity) throws SQLException;
	public Train read(int key) throws SQLException;		
	public List<Train> getAll() throws SQLException, DataNotFoundException;
}
