package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrainDepoDao;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TrainDepo;
import com.roxoft.model.transport.Train;

public class TrainDepoImpl  implements ITrainDepoDao {

	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public TrainDepo read() {
		TrainDaoImpl t = new TrainDaoImpl();
		TrainDepo trainDepo;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			trainDepo = session.selectOne("TrainDepo.getTrainDepoById");
			session.commit();
		} finally {
			session.close();
		}
		trainDepo.setTrains(t.getAll());
		LOG.info(trainDepo.toString());
		return trainDepo;
	}

}
