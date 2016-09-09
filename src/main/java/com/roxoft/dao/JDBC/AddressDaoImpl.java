package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roxoft.dao.IAddressDao;
import com.roxoft.model.Address;

public class AddressDaoImpl implements IAddressDao {
	private  Connection connection;

	public AddressDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Address> getAll() throws SQLException {
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

	@Override
	public void create(Address entity) throws SQLException {
		String sql = "INSERT INTO schema.address (street, house_number) VALUES ('Rokossovskogo', 7);";
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
	public Address read(int key) throws SQLException {
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
		System.out.println(g.toString());
		return g;

	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM schema.address WHERE id= ?";
		PreparedStatement stm = null;
		try {
		stm = connection.prepareStatement(sql);
		stm.setInt(1, id);
		stm.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			stm.close();
		}
	}

}