///**
//* @Title: DataServiceTest.java
//* @Package wisdomnewhome
//* @Description: TODO(用一句话描述该文件做什么)
//* @author Jyg
//* @date 2018年5月5日
//* @version V1.0
//*/
//package wisdomnewhome;
//
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.wisdom.service.DataService;
//
//
//
//
///**
//* @ClassName: DataServiceTest
//* @Description: TODO(这里用一句话描述这个类的作用)
//* @author Jyg
//* @date 2018年5月5日
//*
//*/
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( "classpath:spring-mybatis.xml")  
//public class DataServiceTest {
//
//	static ApplicationContext context =null;
//	
//	@Autowired
//	public DataService dataservice;
//	
//	@BeforeClass
//	public static void init() {
//		context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
//		
//	}
//	
//	@Test
//	public void testDataService() {
//		Map map=new HashMap<>();
//		map.put("userId", "12001");
//		List<Map>  qmap = dataservice.selectLastData(map);
//
//		System.out.println(qmap);
//
//	}
//	
//}
