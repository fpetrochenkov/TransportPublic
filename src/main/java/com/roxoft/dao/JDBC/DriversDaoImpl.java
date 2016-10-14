package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IDriversDao;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;

public class DriversDaoImpl implements IDriversDao {

	private static final Logger LOG = Logger.getLogger(DriversDaoImpl.class);
	private  Connection connection;

	public DriversDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Driver entity) {
		String sql = "INSERT INTO schema.drivers (first_name, last_name, Address_id) "
				+ "VALUES ('Alexey', 'Termik', 8);";
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
	public Driver read(int key) {
		Driver d = new Driver();
		Address a = new Address();
		String sql = "SELECT * FROM schema.drivers inner join address  on drivers.address_id = address.id WHERE drivers.id = ?;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) connection.prepareStatement(sql);
			stm.setInt(1, key);
			rs = stm.executeQuery();
			rs.next();
			d.setId(rs.getInt("id"));
			d.setFirstName(rs.getString("first_name"));
			d.setLastName(rs.getString("last_name"));
			ResultSet addressResultSet = stm.executeQuery();
			while (addressResultSet.next()) {
				a.setStreet(addressResultSet.getString("street"));
				a.setHouseNumber(addressResultSet.getInt("house_number"));
				d.setAddress(a);
				a = new Address();
				d = new Driver();
			}
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
		LOG.info(d.toString());
		return d;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM schema.drivers WHERE id= ?";
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

	@Override
	public ArrayList<Driver> getAll() {
		ArrayList<Driver> list = new ArrayList<Driver>();
		Driver d = new Driver();
		Address a = new Address();
		String sql = "SELECT * FROM schema.drivers inner join address  on drivers.address_id = address.id;";
		ResultSet rs = null;
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				d.setId(rs.getInt("id"));
				d.setFirstName(rs.getString("first_name"));
				d.setLastName(rs.getString("last_name"));
				list.add(d);
				a.setStreet(rs.getString("street"));
				a.setHouseNumber(rs.getInt("house_number"));
				d.setAddress(a);
				a = new Address();
				d = new Driver();
			}
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
		LOG.info(list.toString());
		return list;
	}

}
