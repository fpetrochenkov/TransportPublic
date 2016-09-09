package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.transport.Trolleybus;

public interface ITrolleybusDao <E,K> {

	public void create(Trolleybus entity) throws SQLException;
	public Trolleybus read(int key) throws SQLException;	
	public List<Trolleybus> getAll() throws SQLException;
}
