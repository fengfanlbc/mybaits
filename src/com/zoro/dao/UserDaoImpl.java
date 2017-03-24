package com.zoro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zoro.domain.User;

public class UserDaoImpl implements UserDao {
	
	//注入
	private SqlSessionFactory sessionFactory;
	
	
	public UserDaoImpl(SqlSessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findUserById(int id) {
		//SqlSession是线程不安全的，要定义在方法体内
		SqlSession session = sessionFactory.openSession();
		
		//第一个参数为statement的唯一标识
		User user = session.selectOne("test.findUserById",id);
		
		System.out.println(user);
		
		session.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) {
		SqlSession session = sessionFactory.openSession();
		List<User> list = session.selectOne("test.findUserByName", name);
		System.out.println(list);
		session.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession session = sessionFactory.openSession();
		session.insert("test.insertUser",user);
		session.commit();
		session.close();

	}

}
