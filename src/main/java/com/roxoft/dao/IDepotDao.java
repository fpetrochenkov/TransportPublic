package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.model.Address;
import com.roxoft.model.depos.Depot;

public interface IDepotDao <E, K>{
	
	public void delete(int id);
	public void create(Depot entity);
}
