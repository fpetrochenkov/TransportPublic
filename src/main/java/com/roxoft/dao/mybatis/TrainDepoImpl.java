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

public class TrainDepoImpl extends SessionFactory implements ITrainDepoDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	TrainDaoImpl t = new TrainDaoImpl();
	
	@Override
	public TrainDepo read(){
		TrainDepo trainDepo;
        SqlSession session = SessionFactory.getSession();
        try {
        trainDepo = session.selectOne("TrainDepo.getTrainDepoById");
        session.commit();
        } finally {
        	session.close();
        }
        trainDepo.setTrains(t.getAll());
        rootLogger.info(trainDepo.toString());
        return trainDepo;
	}



}
