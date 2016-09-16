package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITrolleybusDepoDao;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TrolleybusDepo;
import com.roxoft.model.transport.Trolleybus;

public class TrolleybusDepoImpl extends SessionFactory implements ITrolleybusDepoDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	TrolleybusDaoImpl t = new TrolleybusDaoImpl();
	
	@Override
	public TrolleybusDepo read()  {
		TrolleybusDepo trolleybusDepo;
        SqlSession session = SessionFactory.getSession();
        try {
        trolleybusDepo = session.selectOne("TrolleybusDepo.getTrolleybusDepoById");
        session.commit();
        } finally {
        	session.close();
        }
        trolleybusDepo.setTrolleys(t.getAll());
        rootLogger.info(trolleybusDepo.toString());
        return trolleybusDepo;	}

}
