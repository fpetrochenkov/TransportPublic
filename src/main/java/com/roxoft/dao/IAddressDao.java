package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.model.Address;

public interface IAddressDao <E, K> {
	
	public Address read(int key) throws SQLException;	
	public void delete(int id) throws SQLException;
	public List<Address> getAll() throws SQLException;
	void create(Address entity) throws SQLException;

}
