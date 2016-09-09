package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.IBusDao;
import com.roxoft.model.Address;
import com.roxoft.model.transport.Bus;

public class BusDaoImpl extends SessionFactory implements IBusDao{

	@Override
	public void create(Bus entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Bus.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Bus read(int key) throws SQLException {
		Bus bus;
        SqlSession session = SessionFactory.getSession();
        try {
        bus = session.selectOne("Bus.getBusById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(bus.toString());
        return bus;
	}

	@Override
	public List<Bus> getAll() throws SQLException {
		List<Bus> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Bus.getAllBuses");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list.toString());
        return list;
	}

}
