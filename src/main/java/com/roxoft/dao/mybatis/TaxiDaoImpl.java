package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITaxiDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;

public class TaxiDaoImpl  implements ITaxiDao {

	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public void create(Taxi entity) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("Taxi.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Taxi read(int key) {
		Taxi taxi;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			taxi = session.selectOne("Taxi.getTaxiById", key);
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(taxi.toString());
		return taxi;
	}

	@Override
	public List<Taxi> getAll() {
		List<Taxi> list;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("Taxi.getAllTaxis");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

}
