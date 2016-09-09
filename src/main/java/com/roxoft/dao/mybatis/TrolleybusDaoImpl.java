package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.ITrolleybusDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Trolleybus;

public class TrolleybusDaoImpl extends SessionFactory implements ITrolleybusDao{

	@Override
	public void create(Trolleybus entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Trolleybus.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Trolleybus read(int key) throws SQLException {
		Trolleybus trolley;
        SqlSession session = SessionFactory.getSession();
        try {
        	trolley = session.selectOne("Trolleybus.getTrolleybusById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(trolley.toString());
        return trolley;
	}

	@Override
	public List<Trolleybus> getAll() throws SQLException {
		List<Trolleybus> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Trolleybus.getAllTrolleybuses");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list.toString());
        return list;
	}

}
