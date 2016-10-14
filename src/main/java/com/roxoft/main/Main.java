package com.roxoft.main;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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
import com.roxoft.dao.mybatis.BusDepoImpl;
import com.roxoft.dao.mybatis.SessionFactory;
import com.roxoft.dao.mybatis.TaxiStationImpl;
import com.roxoft.dao.mybatis.TrainDepoImpl;
import com.roxoft.dao.mybatis.TramDepoImpl;
import com.roxoft.dao.mybatis.TrolleybusDepoImpl;
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
import com.roxoft.services.DepotService;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {

		LOG.info(
				"----------------------------------------------JDBC--------------------------------------------------------");
		DepotService serv = new DepotService();
		serv.createDepos();
		LOG.info(
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
		 

			LOG.info(
				"---------------------------------------------MyBatis(ver 2)-------------------------------------------------");

			SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();

		try {
			IBusDao busMapper = session.getMapper(IBusDao.class);
			List<Bus> busList = busMapper.getAll();
			ITrolleybusDao trolleybusMapper = session.getMapper(ITrolleybusDao.class);
			List<Trolleybus> trolleyList = trolleybusMapper.getAll();
			ITramDao tramMapper = session.getMapper(ITramDao.class);
			List<Tram> tramList = tramMapper.getAll();
			ITrainDao trainMapper = session.getMapper(ITrainDao.class);
			List<Train> trainList = trainMapper.getAll();
			ITaxiDao taxiMapper = session.getMapper(ITaxiDao.class);
			List<Taxi> taxiList = taxiMapper.getAll();
			IBusDepoDao busDepoMapper = session.getMapper(IBusDepoDao.class);
			BusDepo busDepo = busDepoMapper.read();
			busDepo.setBuses(busList);
			ITrolleybusDepoDao trolleyDepoMapper = session.getMapper(ITrolleybusDepoDao.class);
			TrolleybusDepo trolleyDepo = trolleyDepoMapper.read();
			trolleyDepo.setTrolleys(trolleyList);
			ITramDepoDao tramDepoMapper = session.getMapper(ITramDepoDao.class);
			TramDepo tramDepo = tramDepoMapper.read();
			tramDepo.setTrams(tramList);
			ITrainDepoDao trainDepoMapper = session.getMapper(ITrainDepoDao.class);
			TrainDepo trainDepo = trainDepoMapper.read();
			trainDepo.setTrains(trainList);
			ITaxiStationDao taxiStationMapper = session.getMapper(ITaxiStationDao.class);
			TaxiStation taxiStation = taxiStationMapper.read();
			taxiStation.setTaxis(taxiList);
			LOG.info(busDepo.toString());
			LOG.info(trolleyDepo.toString());
			LOG.info(tramDepo.toString());
			LOG.info(trainDepo.toString());
			LOG.info(taxiStation.toString());
		} finally {
			session.close();
		}

	}
}
