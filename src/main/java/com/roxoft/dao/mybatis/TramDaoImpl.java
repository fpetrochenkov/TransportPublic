package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.ITramDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Tram;

public class TramDaoImpl extends SessionFactory implements ITramDao{

	@Override
	public void create(Tram entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {		
			session.insert("Tram.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Tram read(int key) throws SQLException {
		Tram tram;
        SqlSession session = SessionFactory.getSession();
        try {
        	tram = session.selectOne("Tram.getTramById", key);
        session.commit();
        session.close();
        } finally {
        	session.close();
        }
        System.out.println(tram.toString());
        return tram;
	}

	@Override
	public List<Tram> getAll() throws SQLException {
		List<Tram> list;
		SqlSession session = SessionFactory.getSession();
		try {
        list = session.selectList("Tram.getAllTrams");
        session.commit();
		} finally {
        session.close();
		}
		System.out.println(list.toString());
        return list;
	}

}
