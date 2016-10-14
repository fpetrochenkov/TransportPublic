package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IDepotDao;
import com.roxoft.model.depos.Depot;

public class DepotDaoImpl implements IDepotDao {
	
	private static final Logger LOG = Logger.getLogger(DepotDaoImpl.class);
	private Connection connection;

	public DepotDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Depot entity) {
		String sql = "INSERT INTO schema.depos (name, address_id, transport_type_id)" + "VALUES ('Metro', 1, 5);";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
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

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM schema.depos inner join address  on depos.address_id = address.id WHERE depos.id = ?;";
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
