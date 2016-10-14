package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IDriversDao;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;

public class DriversDaoImpl  implements IDriversDao {

	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public void create(Driver entity) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("Driver.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Driver read(int key) {
		Driver driver;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			driver = session.selectOne("Driver.getDriverById", key);
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(driver.toString());
		return driver;
	}

	@Override
	public void delete(int id) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("Driver.deleteDriverById", id);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Driver> getAll() {
		List<Driver> list;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("Driver.getAllDrivers");
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(list);
		return list;
	}

}
