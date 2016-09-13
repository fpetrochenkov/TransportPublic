package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.transport.Tram;

public interface ITramDao <E,K> {

	
	public void create(Tram entity);
	public Tram read(int key);	
	public List<Tram> getAll();
}
