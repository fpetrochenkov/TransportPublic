package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.ITrainDao;
import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Train;

public class TrainDaoImpl extends SessionFactory implements ITrainDao{

	@Override
	public void create(Train entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Train.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Train read(int key) throws SQLException {
		Train train;
        SqlSession session = SessionFactory.getSession();
        try {
        	train = session.selectOne("Train.getTrainById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(train.toString());
        return train;
	}

	@Override
	public List<Train> getAll() throws SQLException {
		List<Train> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Train.getAllTrains");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list.toString());
        return list;
	}

}
