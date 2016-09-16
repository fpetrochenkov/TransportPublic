package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrainDepoDao;
import com.roxoft.dao.services.DepotService;
import com.roxoft.model.Address;
import com.roxoft.model.depos.TaxiStation;
import com.roxoft.model.depos.TrainDepo;

public class TrainDepoDaoImpl implements ITrainDepoDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();
	private static final Logger LOG = Logger.getLogger(TrainDepoDaoImpl.class);
	
	private  Connection connection;

	public TrainDepoDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public TrainDepo read()  {
		TrainDepo trainDepo = new TrainDepo();
		Address a = new Address();
		String sql = "SELECT name, address.street, address.house_number from schema.depos "
				+ "inner join address  on address.id = depos.address_id where depos.id = 4";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) connection.prepareStatement(sql);
			rs = stm.executeQuery();
			rs.next();
			trainDepo.setName(rs.getString("name"));
			a.setStreet(rs.getString("street"));
			a.setHouseNumber(rs.getInt("house_number"));
			trainDepo.setAddress(a);			
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
					stm.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
			
		}
		return trainDepo;
	}
}
