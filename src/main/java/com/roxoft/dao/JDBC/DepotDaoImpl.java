package com.roxoft.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roxoft.dao.IDepotDao;
import com.roxoft.model.Address;
import com.roxoft.model.Depos;
import com.roxoft.model.Depot;
import com.roxoft.model.Driver;
import com.roxoft.model.Stops;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Transport;
import com.roxoft.model.transport.Trolleybus;

public class DepotDaoImpl implements IDepotDao {
	private  Connection connection;

	public DepotDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Depot entity) throws SQLException {
		String sql = "INSERT INTO schema.depos (name, address_id, transport_type_id)" + "VALUES ('Metro', 1, 5);";
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
	public Depot read(int key) throws SQLException {
		Depot depo = new Depot();
		Address a = new Address();
		String sql = "SELECT * FROM schema.depos WHERE id = ?;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = (PreparedStatement) connection.prepareStatement(sql);
			stm.setInt(1, key);
			rs = stm.executeQuery();
			rs.next();
			depo.setId(rs.getInt("id"));
			depo.setName(rs.getString("name"));
			a.setStreet(rs.getString("street"));
			a.setHouseNumber(rs.getInt("house_number"));
			a = new Address();
			depo.setAddress(a);
			depo = new Depot();
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
		System.out.println(depo.toString());
		return depo;
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM schema.depos inner join address  on depos.address_id = address.id WHERE depos.id = ?;";
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
	
    private Transport getType(int id) {
    	Transport transport = null;
        switch(id) {
            case 1: transport = new Bus();
                break;
            case 2: transport = new Trolleybus();
                break;
            case 3: transport = new Tram();
                break;
            case 4: transport = new Train();
                break;
            case 5: transport = new Taxi();    
            default: break;
        }
        return transport;
    }

	@Override
	public List<Depot> getAll() throws SQLException {
		List<Depot> list = new ArrayList<Depot>();
		Depot depo = new Depot();
		Address a = new Address();
		Address driverAddr = new Address();
		List<Transport> transports = new ArrayList<Transport>();
		Transport transport = null;
		Driver d = new Driver();
		Stops stop = new Stops();
        String sql = "SELECT  name, a.street, a.house_number, transport_type.type, "
        		+ "transport.id, transport_type.id, transport.number,  drivers.first_name, "
        		+ "drivers.last_name, ad.street, ad.house_number, a1.street, a1.house_number,   "
        		+ "a2.street, a2.house_number FROM schema.depos "
        		+ "Inner join transport_type on depos.transport_type_id=transport_type.id "
        		+ "Inner join transport on transport_type.id=transport.transport_type_id "
        		+ "Inner join route on transport.route_id=route.id "
        		+ "Inner join address a1 on route.station_from=a1.id "
        		+ "Inner join address a2 on route.station_to=a2.id "
        		+ "Inner join drivers on transport.drivers_id = drivers.id "
        		+ "Inner join address a on depos.address_id = a.id "
        		+ "Inner join address ad on drivers.address_id = ad.id";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				depo.setName(rs.getString("name"));	
				list.add(depo);
				a.setStreet(rs.getString("street"));
				a.setHouseNumber(rs.getInt("house_number"));//				
				depo.setAddress(a);
				a = new Address();
				    int transportId = rs.getInt("transport.id");
	                int transportTypeId = rs.getInt("transport_type.id");
	                transport = getType(transportTypeId);
	                transport.setId(transportId);
				transport.setId(rs.getInt("id"));
				transport.setNumber(rs.getInt("number"));
				d.setId(rs.getInt("id"));
				d.setFirstName(rs.getString("first_name"));
				d.setLastName(rs.getString("last_name"));
				driverAddr.setStreet(rs.getString(10));
				driverAddr.setHouseNumber(rs.getInt(11));
				d.setAddress(driverAddr);
				transport.setDriver(d);
				driverAddr = new Address();
				d = new Driver();	
				Address from = new Address();
				from.setStreet(rs.getString(12));
				from.setHouseNumber(rs.getInt(13));
				stop.setFrom(from);
				from = new Address();
				Address to = new Address();
				to.setStreet(rs.getString(14));
				to.setHouseNumber(rs.getInt(15));
				stop.setTo(to);
				to = new Address();
				transport.setStop(stop);				
				stop = new Stops();
				transports.add(transport);
				depo.setTransports(transports);				
				transports = new ArrayList<Transport>();
				transport = null;
				depo = new Depot();
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
