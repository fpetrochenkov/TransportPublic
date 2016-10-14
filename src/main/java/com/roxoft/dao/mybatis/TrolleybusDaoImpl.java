package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrolleybusDao;
import com.roxoft.model.transport.Bus;
import com.roxoft.model.transport.Trolleybus;

public class TrolleybusDaoImpl implements ITrolleybusDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public void create(Trolleybus entity){
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {		
			session.insert("Trolleybus.insert", entity);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Trolleybus read(int key){
		Trolleybus trolley;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
        try {
        	trolley = session.selectOne("Trolleybus.getTrolleybusById", key);
        session.commit();
        } finally {
        	session.close();
        }
        rootLogger.info(trolley.toString());
        return trolley;
	}

	@Override
	public List<Trolleybus> getAll(){
		List<Trolleybus> list;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
        list = session.selectList("Trolleybus.getAllTrolleybuses");
        session.commit();
		} finally {
        session.close();
		}
        return list;
	}

}
