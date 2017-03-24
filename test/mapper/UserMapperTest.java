package mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zoro.domain.User;
import com.zoro.domain.UserQueryVO;
import com.zoro.mapper.UserMapper;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	//private UserDao dao;
	
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindUserById(){
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		//User u = mapper.findUserById(1);
		//System.out.println(u);
		
		User user = mapper.findUserRstMap(1);
		System.out.println("resultMap:"+user);

		//session在哪创建在哪关闭
		session.close();
	}
	
	@Test
	public void testInsertUser(){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setAddress("beijing");
		user.setUsername("nana");
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.insertUser(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindUserList(){
		SqlSession session = sqlSessionFactory.openSession();
		UserQueryVO vo = new UserQueryVO();
		User user = new User();
		//user.setAddress("beijing");
		user.setUsername("陈小明");
		user.setSex("1");
		vo.setUser(user);
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.findUserList(vo);
		System.out.println(list);
		//综合查询用户总数
		int count = mapper.findUserCount(vo);
		System.out.println("find people:"+count);
		UserQueryVO vo2 = new UserQueryVO();
		User user2 = new User();
		//user.setAddress("beijing");
		//user2.setUsername("陈小明");
		
		vo2.setUser(user2);
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(10);
		vo2.setIdList(idList);
		List<User> list2 = mapper.findUserList2(vo2);
		System.out.println(list2);

		
		session.close();
	}
}
