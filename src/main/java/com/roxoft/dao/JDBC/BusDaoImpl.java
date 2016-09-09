package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roxoft.dao.IBusDao;
import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.exceptions.IncorrectIdException;
import com.roxoft.exceptions.IncorrectInputException;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;
import com.roxoft.model.Stops;
import com.roxoft.model.transport.Bus;

public class BusDaoImpl implements IBusDao {
	private Connection connection;

	public BusDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Bus entity) throws SQLException {
		String sql = "INSERT INTO schema.transport (id, number, Drivers_id) " + "VALUES (14, 10, 5);";
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(sql);
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			stm.close();
		}
	}

	@Override
	public Bus read(int key) throws SQLException {
		Bus b = new Bus();
		Stops stop = new Stops();
		Driver d = new Driver();
		Address a = new Address();

		String sql = "SELECT name, transport_type.type, transport.number, a1.street, drivers.first_name, "
				+ "drivers.last_name,  a1.house_number, a2.street, a2.house_number FROM schema.depos "
				+ "Inner join transport_type on depos.transport_type_id=transport_type.id "
				+ "Inner join transport on transport_type.id=transport.transport_type_id "
				+ "Inner join route on transport.route_id=route.id "
				+ "Inner join address a1 on route.station_from=a1.id "
				+ "Inner join address a2 on route.station_to=a2.id "
				+ "Inner join drivers on transport.drivers_id = drivers.id where transport_type.id = 1 and transport.id = ?";

		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, key);
			rs = stm.executeQuery();
			while (rs.next()) {
				b.setNumber(rs.getInt("number"));
				d.setFirstName(rs.getString("first_name"));
				d.setLastName(rs.getString("last_name"));
				b.setDriver(d);
				a.setStreet(rs.getString("street"));
				a.setHouseNumber(rs.getInt("house_number"));
				d.setAddress(a);
				a = new Address();
				d = new Driver();
				Address from = new Address();
				from.setStreet(rs.getString("street"));
				from.setHouseNumber(rs.getInt("house_number"));
				stop.setFrom(from);
				from = new Address();
				Address to = new Address();
				to.setStreet(rs.getString(8));
				to.setHouseNumber(rs.getInt(9));
				stop.setTo(to);
				to = new Address();
				b.setStop(stop);
				stop = new Stops();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			stm.close();
		}
		System.out.println(b.toString());
		return b;
	}

	@Override
	public List<Bus> getAll() throws SQLException {
		List<Bus> list = new ArrayList<Bus>();
		Bus b = new Bus();
		Address a = new Address();
		Driver d = new Driver();

		String sql = "SELECT name, transport_type.type, transport.number, a1.street, drivers.first_name, "
				+ "drivers.last_name,  a1.house_number, a2.street, a2.house_number FROM schema.depos "
				+ "Inner join transport_type on depos.transport_type_id=transport_type.id "
				+ "Inner join transport on transport_type.id=transport.transport_type_id "
				+ "Inner join route on transport.route_id=route.id "
				+ "Inner join address a1 on route.station_from=a1.id "
				+ "Inner join address a2 on route.station_to=a2.id "
				+ "Inner join drivers on transport.drivers_id = drivers.id where transport_type.id = 1";

		PreparedStatement stm = null;
		ResultSet rs = null;
		ResultSet addressResultSet = null;
		try {
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			Stops stop = new Stops();
			while (rs.next()) {

				b.setNumber(rs.getInt("number"));
				list.add(b);

				d.setFirstName(rs.getString("first_name"));
				d.setLastName(rs.getString("last_name"));
				b.setDriver(d);

				a.setStreet(rs.getString("street"));
				a.setHouseNumber(rs.getInt("house_number"));
				d.setAddress(a);
				a = new Address();
				d = new Driver();
				Address from = new Address();
				from.setStreet(rs.getString("street"));
				from.setHouseNumber(rs.getInt("house_number"));
				stop.setFrom(from);
				from = new Address();
				Address to = new Address();
				to.setStreet(rs.getString(8));
				to.setHouseNumber(rs.getInt(9));
				stop.setTo(to);
				to = new Address();
				b.setStop(stop);
				b = new Bus();
				stop = new Stops();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (rs != null && addressResultSet != null)
				try {
					rs.close();
					addressResultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			stm.close();
		}
		System.out.println(list.toString());
		return list;
	}

	

}
