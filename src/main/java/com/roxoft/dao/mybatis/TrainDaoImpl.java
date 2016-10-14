package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrainDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Train;

public class TrainDaoImpl  implements ITrainDao {

	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public void create(Train entity) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("Train.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Train read(int key) {
		Train train;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			train = session.selectOne("Train.getTrainById", key);
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(train.toString());
		return train;
	}

	@Override
	public List<Train> getAll() {
		List<Train> list;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("Train.getAllTrains");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

}
