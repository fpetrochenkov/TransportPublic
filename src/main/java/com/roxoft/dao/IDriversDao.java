package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.Driver;

public interface IDriversDao <E, K>{
	
	public void create(Driver entity) throws SQLException;
	public Driver read(int key) throws SQLException;	
	public void delete(int id) throws SQLException;
	public List<Driver> getAll() throws SQLException;
}
