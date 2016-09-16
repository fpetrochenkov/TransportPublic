package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITaxiStationDao;
import com.roxoft.model.Address;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TaxiStation;

public class TaxiStationDaoImpl implements ITaxiStationDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();
	private static final Logger LOG = Logger.getLogger(TaxiStationDaoImpl.class);
	
	private  Connection connection;

	public TaxiStationDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public TaxiStation read() {
		TaxiStation taxiStation = new TaxiStation();
		Address a = new Address();
		String sql = "SELECT name, address.street, address.house_number from schema.depos "
				+ "inner join address  on address.id = depos.address_id where depos.id = 5";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) connection.prepareStatement(sql);
			rs = stm.executeQuery();
			rs.next();
			taxiStation.setName(rs.getString("name"));
			a.setStreet(rs.getString("street"));
			a.setHouseNumber(rs.getInt("house_number"));
			taxiStation.setAddress(a);			
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
		return taxiStation;
	}
}
