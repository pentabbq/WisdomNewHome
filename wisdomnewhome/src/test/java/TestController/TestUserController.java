///**
//* @Title: TestUserController.java
//* @Package TestController
//* @Description: TODO(用一句话描述该文件做什么)
//* @author Jyg
//* @date 2018年5月9日
//* @version V1.0
//*/
//package TestController;
//
//
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.wisdom.controller.UserController;
//
///**
//* @ClassName: TestUserController
//* @Description: 二次登陸校驗
//* @author Jyg
//* @date 2018年5月9日
//*
//*/
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
//public class TestUserController {
//	private MockMvc mockmvc;
//
//	
//	@Autowired
//	private UserController usercontroller;
//	
//	
//	@Before
//	public void setup() {
//		//初始化mockmvc對象
//		mockmvc = MockMvcBuilders.standaloneSetup(usercontroller).build();		
//	}
//	
//	@Test
//	public void ctest()throws Exception{
//		
//		ResultActions resultaction  =this.mockmvc.perform(MockMvcRequestBuilders.post("/user/selectbyid").param("userId", "12001"));
//		
//		MvcResult mvcresult = resultaction.andReturn();
//		
//		
//		String c=mvcresult.getResponse().getContentAsString();
//		System.out.println(c);
//	}
//	
//	
//}
