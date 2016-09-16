package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IBusDepoDao;
import com.roxoft.main.Main;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.transport.Bus;

public class BusDepoImpl extends SessionFactory implements IBusDepoDao {
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	BusDaoImpl b = new BusDaoImpl();

	@Override
	public BusDepo read()  {		
		BusDepo busDepo;
		SqlSession session = SessionFactory.getSession();
		try {
			busDepo = session.selectOne("BusDepo.getBusDepoById");
			session.commit();
		} finally {
			session.close();
		}
		busDepo.setBuses(b.getAll());
		rootLogger.info(busDepo.toString());
		return busDepo;
	}

}
