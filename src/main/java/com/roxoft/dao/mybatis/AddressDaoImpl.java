package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.roxoft.dao.IAddressDao;
import com.roxoft.model.Address;

public class AddressDaoImpl implements IAddressDao {
	
	private static final Logger LOG = LogManager.getRootLogger();

	@Override
	public Address read(int key) {
		Address address;
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			address = session.selectOne("Address.getAddressById", key);
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(address.toString());
		return address;
	}

	@Override
	public void delete(int id) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
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
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("Address.getAllAddresses");
			session.commit();
		} finally {
			session.close();
		}
		LOG.info(list.toString());
		return list;
	}

	@Override
	public void create(Address entity) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("Address.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

}
