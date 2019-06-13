///**
//* @Title: UserServiceTest.java
//* @Package wisdomnewhome
//* @Description: TODO(用一句话描述该文件做什么)
//* @author Jyg
//* @date 2018年5月4日
//* @version V1.0
//*/
//package wisdomnewhome;
//
//
//
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
//import com.wisdom.bean.User;
//import com.wisdom.dao.UserMapper;
//import com.wisdom.service.UserService;
//
///**
//* @ClassName: UserServiceTest
//* @Description: TODO(这里用一句话描述这个类的作用)
//* @author Jyg
//* @date 2018年5月4日
//*
//*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( "classpath:spring-mybatis.xml")  
//public class UserServiceTest {
//	static ApplicationContext context =null;
//	@Autowired
//	public  UserService userservice;
//	
//	@Autowired
//	public UserMapper usermapper;
//	
//	
//	@BeforeClass
//	public static void init() {
//		context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
//		
//	}
//	
//	@Test
//	public void logInTest() {
//		userservice = (UserService) context.getBean("userService");
////		User quser= userservice.logIn("12001", "jyg");
//		
////		User quesr = usermapper.selectUserById("12001");
////		System.out.println(quesr.getUsername());
////		User qquser =userservice.selectUser("12002");
////	    System.out.println(qquser.getOpenid());
//		
//		Map updatemap = userservice.update("12001", "123456", "654321");
//		System.out.println(updatemap.get("update"));
////		boolean a = usermapper.update("123456", "12001");
////		System.out.println(a);
//		
//	}
//	
//}
