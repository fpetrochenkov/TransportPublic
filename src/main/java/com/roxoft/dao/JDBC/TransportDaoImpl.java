package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITransportDao;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;
import com.roxoft.model.Stops;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Transport;
import com.roxoft.model.transport.Trolleybus;

public class TransportDaoImpl implements ITransportDao {
	
	private static final Logger rootLogger = LogManager.getRootLogger();
	private static final Logger LOG = Logger.getLogger(TransportDaoImpl.class);
	private  Connection connection;

	public TransportDaoImpl(Connection connection) {
		this.connection = connection;
	}



	@Override
	public void delete(int id) {
		String sql = "DELETE FROM mydb.transport WHERE id= ?";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
		}

	}

}
