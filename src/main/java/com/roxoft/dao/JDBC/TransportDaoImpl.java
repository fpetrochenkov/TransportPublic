package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	private  Connection connection;

	public TransportDaoImpl(Connection connection) {
		this.connection = connection;
	}



	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM mydb.transport WHERE id= ?";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

	}

}
