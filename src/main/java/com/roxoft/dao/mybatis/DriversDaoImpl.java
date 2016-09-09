package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.IDriversDao;
import com.roxoft.model.Address;
import com.roxoft.model.Driver;

public class DriversDaoImpl extends SessionFactory implements IDriversDao{

	@Override
	public void create(Driver entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Driver.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Driver read(int key) throws SQLException {
		Driver driver;
        SqlSession session = SessionFactory.getSession();
        try {
        	driver = session.selectOne("Driver.getDriverById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(driver.toString());
        return driver;
	}

	@Override
	public void delete(int id) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Driver.deleteDriverById", id);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Driver> getAll() throws SQLException {
		List<Driver> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Driver.getAllDrivers");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list);
        return list;
	}

}
