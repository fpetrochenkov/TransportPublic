package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITaxiStationDao;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TaxiStation;

public class TaxiStationImpl extends SessionFactory implements ITaxiStationDao{
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	TaxiDaoImpl t = new TaxiDaoImpl();
	
	@Override
	public TaxiStation read() {
		TaxiStation taxiStation;
        SqlSession session = SessionFactory.getSession();
        try {
        	taxiStation = session.selectOne("TaxiStation.getTaxiStationById");
        session.commit();
        } finally {
        	session.close();
        }
        taxiStation.setTaxis(t.getAll());
        rootLogger.info(taxiStation.toString());
        return taxiStation;
	}



}
