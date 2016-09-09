package com.roxoft.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.roxoft.dao.IAddressDao;
import com.roxoft.model.Address;

public class AddressDaoImpl extends SessionFactory implements IAddressDao {

	@Override
	public Address read(int key) throws SQLException {
		Address address;
		SqlSession session = SessionFactory.getSession();
		try {
			address = session.selectOne("Address.getAddressById", key);
			session.commit();
			session.close();
		} finally {
			session.close();
		}
		System.out.println(address.toString());
		return address;
	}

	@Override
	public void delete(int id) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Address_Mapper.deleteAddressById", id);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Address> getAll() throws SQLException {
		List<Address> list;
		SqlSession session = SessionFactory.getSession();
		try {
			list = session.selectList("Address.getAllAddresses");
			session.commit();
		} finally {
			session.close();
		}
		System.out.println(list.toString());
		return list;
	}

	@Override
	public void create(Address entity) throws SQLException {
		SqlSession session = SessionFactory.getSession();
		try {
			session.insert("Address_Mapper.insert", entity);
			session.commit();
		} finally {
			session.close();
		}

	}

}
