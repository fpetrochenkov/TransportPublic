package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.roxoft.dao.IDepotDao;
import com.roxoft.model.Address;
import com.roxoft.model.depos.Depot;

public class DepotDaoImpl extends SessionFactory implements IDepotDao {

	@Override
	public void create(Depot entity){
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Depot.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(int id) {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Depot.deleteDepotById", id);
			session.commit();
		} finally {
			session.close();
		}
	}



}
