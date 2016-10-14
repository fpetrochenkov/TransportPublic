package com.roxoft.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.roxoft.model.transport.Bus;

public interface IBusDao {

	public void create(Bus entity);

	public Bus read(int key);

	public List<Bus> getAll();

}
