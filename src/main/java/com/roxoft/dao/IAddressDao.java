package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.roxoft.model.Address;

public interface IAddressDao {

	public Address read(int key);

	public void delete(int id);

	public List<Address> getAll();

	void create(Address entity);

}
