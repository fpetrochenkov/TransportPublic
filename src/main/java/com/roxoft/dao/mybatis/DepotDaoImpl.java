package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.IDepotDao;
import com.roxoft.model.Address;
import com.roxoft.model.Depot;

public class DepotDaoImpl extends SessionFactory implements IDepotDao {

	@Override
	public void create(Depot entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Depot.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Depot read(int key) throws SQLException {
		Depot depo;
		SqlSession session = SessionFactory.getSession();
		try {
			depo = session.selectOne("Depot.getDepotById", key);
			session.commit();
			session.close();
		} finally {
			session.close();
		}
		System.out.println(depo.toString());
		return depo;
	}

	@Override
	public void delete(int id) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Depot.deleteDepotById", id);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Depot> getAll() throws SQLException {
		List<Depot> list;
		SqlSession session = SessionFactory.getSession();
		try {
			list = session.selectList("Depot.getAllDepos");
			session.commit();
		} finally {
			session.close();
		}
		System.out.println(list.toString());
		return list;
	}

}
