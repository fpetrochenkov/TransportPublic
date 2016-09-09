package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roxoft.dao.IDriversDao;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;

public class DriversDaoImpl implements IDriversDao {

	private  Connection connection;

	public DriversDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Driver entity) throws SQLException {
		String sql = "INSERT INTO schema.drivers (first_name, last_name, Address_id) "
				+ "VALUES ('Alexey', 'Termik', 8);";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
	}

	@Override
	public Driver read(int key) throws SQLException {
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
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			stm.close();
		}
		System.out.println(d.toString());
		return d;
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM schema.drivers WHERE id= ?";
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

	@Override
	public ArrayList<Driver> getAll() throws SQLException {
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
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			stm.close();
		}
		System.out.println(list.toString());
		return list;
	}

}
