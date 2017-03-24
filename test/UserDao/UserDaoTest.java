package UserDao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zoro.dao.UserDao;
import com.zoro.dao.UserDaoImpl;
import com.zoro.domain.User;

public class UserDaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	private UserDao dao;
	
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		dao = new UserDaoImpl(sqlSessionFactory);
	}
	
	@Test
	public void testFindUserById(){
		User user = dao.findUserById(1);
		System.out.println(user);
	}

}
