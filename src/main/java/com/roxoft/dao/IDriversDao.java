package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.Driver;

public interface IDriversDao <E, K>{
	
	public void create(Driver entity);
	public Driver read(int key);	
	public void delete(int id);
	public List<Driver> getAll();
}
