package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITramDepoDao;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TramDepo;
import com.roxoft.model.transport.Tram;

public class TramDepoImpl  implements ITramDepoDao{

	private static final Logger rootLogger = LogManager.getRootLogger();
	
	TramDaoImpl t = new TramDaoImpl();
	
	@Override
	public TramDepo read()  {
		TramDepo tramDepo;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
        try {
        tramDepo = session.selectOne("TramDepo.getTramDepoById");
        session.commit();
        } finally {
        	session.close();
        }
        tramDepo.setTrams(t.getAll());
        rootLogger.info(tramDepo.toString());
        return tramDepo;	}
}
