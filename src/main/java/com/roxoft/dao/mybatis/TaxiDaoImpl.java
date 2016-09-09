package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.ITaxiDao;
import com.roxoft.exceptions.DataNotFoundException;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Taxi;

public class TaxiDaoImpl extends SessionFactory implements ITaxiDao{

	@Override
	public void create(Taxi entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Taxi.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Taxi read(int key) throws SQLException {
		Taxi taxi;
        SqlSession session = SessionFactory.getSession();
        try {
        	taxi = session.selectOne("Taxi.getTaxiById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(taxi.toString());
        return taxi;
	}

	@Override
	public List<Taxi> getAll() throws SQLException {
		List<Taxi> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Taxi.getAllTaxis");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list.toString());
        return list;
	}

}
