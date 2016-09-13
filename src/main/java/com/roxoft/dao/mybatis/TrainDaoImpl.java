package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrainDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Train;

public class TrainDaoImpl extends SessionFactory implements ITrainDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void create(Train entity)  {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Train.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Train read(int key)  {
		Train train;
        SqlSession session = SessionFactory.getSession();
        try {
        	train = session.selectOne("Train.getTrainById", key);
        session.commit();
        } finally {
        	session.close();
        }
        rootLogger.info(train.toString());
        return train;
	}

	@Override
	public List<Train> getAll()  {
		List<Train> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Train.getAllTrains");
        session.commit();
		} finally {
        session.close();
		}
        return list;
	}

}
