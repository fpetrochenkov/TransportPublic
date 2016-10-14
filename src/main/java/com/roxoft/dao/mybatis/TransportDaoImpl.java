package com.roxoft.dao.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.ITransportDao;

public class TransportDaoImpl  implements ITransportDao{

	

	@Override
	public void delete(int id)  {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {		
			session.insert("Transport.deleteTransportById", id);
			session.commit();
		} finally {
			session.close();
		}
		
	}

}
