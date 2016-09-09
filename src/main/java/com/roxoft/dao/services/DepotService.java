package com.roxoft.dao.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.roxoft.dao.JDBC.AddressDaoImpl;
import com.roxoft.dao.JDBC.BusDaoImpl;
import com.roxoft.dao.JDBC.DepotDaoImpl;
import com.roxoft.dao.JDBC.DriversDaoImpl;
import com.roxoft.dao.JDBC.TaxiDaoImpl;
import com.roxoft.dao.JDBC.TrainDaoImpl;
import com.roxoft.dao.JDBC.TramDaoImpl;
import com.roxoft.dao.JDBC.TrolleybusDaoImpl;
import com.roxoft.dbcp.DataSourceFactory;
import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.model.Address;
import com.roxoft.model.Depot;
import com.roxoft.model.Driver;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Trolleybus;

public class DepotService {

	private ArrayList<Bus> buses = new ArrayList<Bus>();
	private ArrayList<Trolleybus> trolleybuses = new ArrayList<Trolleybus>();
	private ArrayList<Tram> trams = new ArrayList<Tram>();
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ArrayList<Taxi> taxis = new ArrayList<Taxi>();
	private ArrayList<Depot> depos = new ArrayList<Depot>();
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private ArrayList<Address> addresses = new ArrayList<Address>();

	DataSource dataSource = DataSourceFactory.getDataSource();
	Connection connection = null;

	public void createDepos() throws FileNotFoundException, IOException, DataNotFoundException {

		try {

			connection = dataSource.getConnection();

			DepotDaoImpl depoDao = new DepotDaoImpl(connection);
			BusDaoImpl busDao = new BusDaoImpl(connection);
			TrolleybusDaoImpl trolleyDao = new TrolleybusDaoImpl(connection);
			TramDaoImpl tramDao = new TramDaoImpl(connection);
			TrainDaoImpl trainDao = new TrainDaoImpl(connection);
			TaxiDaoImpl taxiDao = new TaxiDaoImpl(connection);
			DriversDaoImpl driversDao = new DriversDaoImpl(connection);
			AddressDaoImpl addrDao = new AddressDaoImpl(connection);

			depos.addAll(depoDao.getAll());
			buses.addAll(busDao.getAll());
			trolleybuses.addAll(trolleyDao.getAll());
			trams.addAll(tramDao.getAll());
			trains.addAll(trainDao.getAll());
			taxis.addAll(taxiDao.getAll());
			drivers = driversDao.getAll();
			addresses.addAll(addrDao.getAll());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public ArrayList<Depot> getDepos() {
		return depos;
	}

	public ArrayList<Bus> getBuses() {
		return buses;
	}

	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}

	public ArrayList<Trolleybus> getTrolleys() {
		return trolleybuses;
	}

	public void setTrolleys(ArrayList<Trolleybus> trolleybuses) {
		this.trolleybuses = trolleybuses;
	}

	public ArrayList<Tram> getTrams() {
		return trams;
	}

	public void setTrams(ArrayList<Tram> trams) {
		this.trams = trams;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}

	public void setTrains(ArrayList<Train> trains) {
		this.trains = trains;
	}

	public ArrayList<Taxi> getTaxis() {
		return taxis;
	}

	public void setTaxis(ArrayList<Taxi> taxis) {
		this.taxis = taxis;
	}

}
