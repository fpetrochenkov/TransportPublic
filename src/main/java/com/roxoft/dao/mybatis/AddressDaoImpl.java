package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IAddressDao;
import com.roxoft.model.Address;

public class AddressDaoImpl extends SessionFactory implements IAddressDao {
	
	private static final Logger rootLogger = LogManager.getRootLogger();

	@Override
	public Address read(int key) {
		Address address;
		SqlSession session = SessionFactory.getSession();
		try {
			address = session.selectOne("Address.getAddressById", key);
			session.commit();
		} finally {
			session.close();
		}
		rootLogger.info(address.toString());
		return address;
	}

	@Override
	public void delete(int id) {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Address.deleteAddressById", id);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Address> getAll() {
		List<Address> list;
		SqlSession session = SessionFactory.getSession();
		try {
			list = session.selectList("Address.getAllAddresses");
			session.commit();
		} finally {
			session.close();
		}
		rootLogger.info(list.toString());
		return list;
	}

	@Override
	public void create(Address entity) {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Address.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

}
