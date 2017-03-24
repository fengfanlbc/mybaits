package mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zoro.domain.OrdersExt;
import com.zoro.mapper.OrdersMapper;

public class OrderMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	//private UserDao dao;
	
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void testOrderFind(){
		SqlSession session = sqlSessionFactory.openSession();
		OrdersMapper mapper = session.getMapper(OrdersMapper.class);
		List<OrdersExt> list = mapper.findOrdersAndUser();
		System.out.println(list);
		session.close();
		
	}
}
