package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.model.Depos;
import com.roxoft.model.Depot;

public interface IDepotDao <E, K>{

	
	public void create(Depot entity) throws SQLException;
	public Depot read(int key) throws SQLException;	
	public void delete(int id) throws SQLException;
	public List<Depot> getAll() throws SQLException;
}
