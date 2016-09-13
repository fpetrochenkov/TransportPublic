package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.transport.Trolleybus;

public interface ITrolleybusDao <E,K> {

	public void create(Trolleybus entity);
	public Trolleybus read(int key);	
	public List<Trolleybus> getAll();
}
