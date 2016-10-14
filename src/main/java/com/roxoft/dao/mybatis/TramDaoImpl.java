package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITramDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Tram;

public class TramDaoImpl  implements ITramDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void create(Tram entity)  {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {		
			session.insert("Tram.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Tram read(int key)  {
		Tram tram;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
        try {
        	tram = session.selectOne("Tram.getTramById", key);
        session.commit();
        } finally {
        	session.close();
        }
        rootLogger.info(tram.toString());
        return tram;
	}

	@Override
	public List<Tram> getAll()  {
		List<Tram> list;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
        list = session.selectList("Tram.getAllTrams");
        session.commit();
		} finally {
        session.close();
		}
        return list;
	}

}
