package com.roxoft.dao.mybatis;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;

public abstract class SessionFactory  {
	
	private static final String resource = "mybatis/mybatis_config.xml";
    private static SqlSessionFactory sessionFactory = null;
    private static InputStream input;
    private SqlSession session;

    public static SqlSession getSession() {
        if(sessionFactory == null) {
            try {
                input = Resources.getResourceAsStream(resource);
                sessionFactory = new SqlSessionFactoryBuilder().build(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }

    public void close() {
        if(session != null) {
            session.close();
        }
    }

}
