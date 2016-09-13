package com.roxoft.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IAddressDao;
import com.roxoft.dao.IBusDao;
import com.roxoft.dao.IBusDepoDao;
import com.roxoft.dao.ITaxiDao;
import com.roxoft.dao.ITaxiStationDao;
import com.roxoft.dao.ITrainDao;
import com.roxoft.dao.ITrainDepoDao;
import com.roxoft.dao.ITramDao;
import com.roxoft.dao.ITramDepoDao;
import com.roxoft.dao.ITrolleybusDao;
import com.roxoft.dao.ITrolleybusDepoDao;
import com.roxoft.dao.mybatis.AddressDaoImpl;
import com.roxoft.dao.mybatis.BusDaoImpl;
import com.roxoft.dao.mybatis.BusDepoImpl;
import com.roxoft.dao.mybatis.DriversDaoImpl;
import com.roxoft.dao.mybatis.SessionFactory;
import com.roxoft.dao.mybatis.TaxiDaoImpl;
import com.roxoft.dao.mybatis.TaxiStationImpl;
import com.roxoft.dao.mybatis.TrainDaoImpl;
import com.roxoft.dao.mybatis.TrainDepoImpl;
import com.roxoft.dao.mybatis.TramDaoImpl;
import com.roxoft.dao.mybatis.TramDepoImpl;
import com.roxoft.dao.mybatis.TrolleybusDaoImpl;
import com.roxoft.dao.mybatis.TrolleybusDepoImpl;
import com.roxoft.dao.services.DepotService;
import com.roxoft.model.Address;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TaxiStation;
import com.roxoft.model.depos.TrainDepo;
import com.roxoft.model.depos.TramDepo;
import com.roxoft.model.depos.TrolleybusDepo;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;
import com.roxoft.model.transport.Train;
import com.roxoft.model.transport.Tram;
import com.roxoft.model.transport.Trolleybus;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class);
	private static final Logger rootLogger = LogManager.getRootLogger();

	public static void main(String[] args) throws SQLException {

		rootLogger.info(
				"----------------------------------------------JDBC--------------------------------------------------------");
		DepotService serv = new DepotService();
		serv.createDepos();
		rootLogger.info(
				"---------------------------------------------MyBatis------------------------------------------------------");
		
			BusDepoImpl b = new BusDepoImpl();
			b.read();
			TrolleybusDepoImpl tDepo = new TrolleybusDepoImpl();
			tDepo.read();
			TramDepoImpl t = new TramDepoImpl();
			t.read();
			TrainDepoImpl tt = new TrainDepoImpl();
			tt.read();
			TaxiStationImpl taxi = new TaxiStationImpl();
			taxi.read();
		 

		rootLogger.info(
				"---------------------------------------------MyBatis(ver 2)-------------------------------------------------");

		SqlSession session = SessionFactory.getSession();

		try {
			IBusDao busMapper = SessionFactory.getSession().getMapper(IBusDao.class);
			List<Bus> busList = busMapper.getAll();
			ITrolleybusDao trolleybusMapper = SessionFactory.getSession().getMapper(ITrolleybusDao.class);
			List<Trolleybus> trolleyList = trolleybusMapper.getAll();
			ITramDao tramMapper = SessionFactory.getSession().getMapper(ITramDao.class);
			List<Tram> tramList = tramMapper.getAll();
			ITrainDao trainMapper = SessionFactory.getSession().getMapper(ITrainDao.class);
			List<Train> trainList = trainMapper.getAll();
			ITaxiDao taxiMapper = SessionFactory.getSession().getMapper(ITaxiDao.class);
			List<Taxi> taxiList = taxiMapper.getAll();
			IBusDepoDao busDepoMapper = SessionFactory.getSession().getMapper(IBusDepoDao.class);
			BusDepo busDepo = busDepoMapper.read();
			busDepo.setBuses(busList);
			ITrolleybusDepoDao trolleyDepoMapper = SessionFactory.getSession().getMapper(ITrolleybusDepoDao.class);
			TrolleybusDepo trolleyDepo = trolleyDepoMapper.read();
			trolleyDepo.setTrolleys(trolleyList);
			ITramDepoDao tramDepoMapper = SessionFactory.getSession().getMapper(ITramDepoDao.class);
			TramDepo tramDepo = tramDepoMapper.read();
			tramDepo.setTrams(tramList);
			ITrainDepoDao trainDepoMapper = SessionFactory.getSession().getMapper(ITrainDepoDao.class);
			TrainDepo trainDepo = trainDepoMapper.read();
			trainDepo.setTrains(trainList);
			ITaxiStationDao taxiStationMapper = SessionFactory.getSession().getMapper(ITaxiStationDao.class);
			TaxiStation taxiStation = taxiStationMapper.read();
			taxiStation.setTaxis(taxiList);
			rootLogger.info(busDepo.toString());
			rootLogger.info(trolleyDepo.toString());
			rootLogger.info(tramDepo.toString());
			rootLogger.info(trainDepo.toString());
			rootLogger.info(taxiStation.toString());
		} finally {
			session.close();
		}

	}
}
