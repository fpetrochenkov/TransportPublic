package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.ITaxiStationDao;
import com.roxoft.model.depos.BusDepo;
import com.roxoft.model.depos.TaxiStation;

public class TaxiStationImpl  implements ITaxiStationDao{
	
	private static final Logger LOG = LogManager.getRootLogger();

	
	
	@Override
	public TaxiStation read() {
		TaxiDaoImpl t = new TaxiDaoImpl();
		TaxiStation taxiStation;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
        try {
        	taxiStation = session.selectOne("TaxiStation.getTaxiStationById");
        session.commit();
        } finally {
        	session.close();
        }
        taxiStation.setTaxis(t.getAll());
        LOG.info(taxiStation.toString());
        return taxiStation;
	}



}
