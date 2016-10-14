package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;
import com.roxoft.model.transport.Taxi;

public interface ITaxiDao {

	public void create(Taxi entity);

	public Taxi read(int key);

	public List<Taxi> getAll();
}
