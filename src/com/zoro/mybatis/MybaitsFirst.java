package com.zoro.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zoro.domain.User;

public class MybaitsFirst {
	public static void main(String[] args) throws IOException {
		
	}
	@Test
	public void findUserByIdTest() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream input = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//User user = sqlSession.selectOne("test.findUserById",10);
		//System.out.println(user);
		//模糊查询
//		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
//		System.out.println(list);
		
		//添加用户
		User u1 = new User();
		u1.setUsername("feng");
		//u1.setId(5);
		u1.setAddress("beijing");
		sqlSession.insert("test.insertUser", u1);
		//更新操作需要提交事务
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(u1.getId());
	}
}
