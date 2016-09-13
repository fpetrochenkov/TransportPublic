package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IBusDao;
import com.roxoft.model.Address;
import com.roxoft.model.transport.Bus;

public class BusDaoImpl extends SessionFactory implements IBusDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void create(Bus entity) {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Bus.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Bus read(int key) {
		Bus bus;
        SqlSession session = SessionFactory.getSession();
        try {
        bus = session.selectOne("Bus.getBusById", key);
        session.commit();
        } finally {
        	session.close();
        }
        rootLogger.info(bus.toString());
        return bus;
	}

	@Override
	public List<Bus> getAll() {
		List<Bus> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Bus.getAllBuses");
        session.commit();
		} finally {
        session.close();
		}
        return list;
	}

}
