package com.roxoft.dao.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.roxoft.dao.JDBC.AddressDaoImpl;
import com.roxoft.dao.JDBC.BusDaoImpl;
import com.roxoft.dao.JDBC.BusDepoDaoImpl;
//import com.roxoft.dao.JDBC.DepotDaoImpl;
import com.roxoft.dao.JDBC.DriversDaoImpl;
import com.roxoft.dao.JDBC.TaxiDaoImpl;
import com.roxoft.dao.JDBC.TaxiStationDaoImpl;
import com.roxoft.dao.JDBC.TrainDaoImpl;
import com.roxoft.dao.JDBC.TrainDepoDaoImpl;
import com.roxoft.dao.JDBC.TramDaoImpl;
import com.roxoft.dao.JDBC.TramDepoDaoImpl;
import com.roxoft.dao.JDBC.TrolleybusDaoImpl;
import com.roxoft.dao.JDBC.TrolleybusDepoDaoImpl;
import com.roxoft.dbcp.DataSourceFactory;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.Depot;
import com.roxoft.model.depos.TaxiStation;
import com.roxoft.model.depos.TrainDepo;
import com.roxoft.model.depos.TramDepo;
import com.roxoft.model.depos.TrolleybusDepo;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Trolleybus;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DepotService {

	private static final Logger rootLogger = LogManager.getRootLogger();
	private static final Logger LOG = Logger.getLogger(DepotService.class);

	private ArrayList<Bus> buses = new ArrayList<Bus>();
	private ArrayList<Trolleybus> trolleybuses = new ArrayList<Trolleybus>();
	private ArrayList<Tram> trams = new ArrayList<Tram>();
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ArrayList<Taxi> taxis = new ArrayList<Taxi>();

	DataSource dataSource = DataSourceFactory.getDataSource();
	Connection connection = null;

	public void createDepos() {

		try {

			connection = dataSource.getConnection();

			BusDaoImpl busDao = new BusDaoImpl(connection);
			TrolleybusDaoImpl trolleyDao = new TrolleybusDaoImpl(connection);
			TramDaoImpl tramDao = new TramDaoImpl(connection);
			TrainDaoImpl trainDao = new TrainDaoImpl(connection);
			TaxiDaoImpl taxiDao = new TaxiDaoImpl(connection);

			BusDepoDaoImpl b = new BusDepoDaoImpl(connection);
			BusDepo busDepo = new BusDepo();
			busDepo = b.read();
			buses.addAll(busDao.getAll());
			busDepo.setBuses(buses);
			rootLogger.info(busDepo.toString());

			TrolleybusDepoDaoImpl t = new TrolleybusDepoDaoImpl(connection);
			TrolleybusDepo trolleyDepo = new TrolleybusDepo();
			trolleyDepo = t.read();
			trolleybuses.addAll(trolleyDao.getAll());
			trolleyDepo.setTrolleys(trolleybuses);
			rootLogger.info(trolleyDepo.toString());

			TramDepoDaoImpl tr = new TramDepoDaoImpl(connection);
			TramDepo tramDepo = new TramDepo();
			tramDepo = tr.read();
			trams.addAll(tramDao.getAll());
			tramDepo.setTrams(trams);
			rootLogger.info(tramDepo.toString());

			TrainDepoDaoImpl td = new TrainDepoDaoImpl(connection);
			TrainDepo trainDepo = new TrainDepo();
			trainDepo = td.read();
			trains.addAll(trainDao.getAll());
			trainDepo.setTrains(trains);
			rootLogger.info(trainDepo.toString());

			TaxiStationDaoImpl ta = new TaxiStationDaoImpl(connection);
			TaxiStation taxiStation = new TaxiStation();
			taxiStation = ta.read();
			taxis.addAll(taxiDao.getAll());
			taxiStation.setTaxis(taxis);
			rootLogger.info(taxiStation.toString());

		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
		}

	}

}
