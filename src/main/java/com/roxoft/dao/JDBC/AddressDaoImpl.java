package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IAddressDao;
import com.roxoft.model.Address;

public class AddressDaoImpl implements IAddressDao {

	private static final Logger rootLogger = LogManager.getRootLogger();
	private static final Logger LOG = Logger.getLogger(AddressDaoImpl.class);

	private Connection connection;

	public AddressDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Address> getAll() {
		List<Address> list = new ArrayList<Address>();
		String sql = "SELECT * FROM schema.address;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Address g = new Address();
				g.setId(rs.getInt("id"));
				g.setStreet(rs.getString("street"));
				g.setHouseNumber(rs.getInt("house_number"));
				list.add(g);
			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (rs != null && stm != null)
				try {
					rs.close();
					stm.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}

		}
		rootLogger.info(list.toString());
		return list;
	}

	@Override
	public void create(Address entity) {
		String sql = "INSERT INTO schema.address (street, house_number) VALUES ('Rokossovskogo', 7);";
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
	public Address read(int key) {
		Address g = new Address();
		String sql = "SELECT * FROM schema.address WHERE id = ?;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) connection.prepareStatement(sql);
			stm.setInt(1, key);
			rs = stm.executeQuery();
			rs.next();

			g.setId(rs.getInt("id"));
			g.setStreet(rs.getString("street"));
			g.setHouseNumber(rs.getInt("house_number"));
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (rs != null && stm != null)
				try {
					rs.close();
					stm.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
		}
		rootLogger.info(g.toString());
		return g;

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM schema.address WHERE id= ?";
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