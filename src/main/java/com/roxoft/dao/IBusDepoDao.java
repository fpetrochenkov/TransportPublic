package com.roxoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.transport.Bus;

public interface IBusDepoDao {	
	public BusDepo read();
}
