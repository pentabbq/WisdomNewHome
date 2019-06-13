///**
//* @Title: UserControllerTest.java
//* @Package TestController
//* @Description: TODO(用一句话描述该文件做什么)
//* @author Jyg
//* @date 2018年5月12日
//* @version V1.0
//*/
//package TestController;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.wisdom.controller.DataController;
//import com.wisdom.controller.UserController;
//
///**
//* @ClassName: UserControllerTest
//* @Description: TODO(这里用一句话描述这个类的作用)
//* @author Jyg
//* @date 2018年5月12日
//*
//*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations= {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
//public class UserControllerTest {
//
//	private MockMvc mockmvc;
//	private MockHttpSession session;
//	private MockHttpServletRequest request;
//	@Autowired
//	private WebApplicationContext wac;
//	
//	@Autowired
//	private UserController usercontroller;
//	
//	@Autowired
//	private DataController datacontroller;
//	
//	
//	@Before
//	public void setup() {
//		//初始化mockmvc對象
//		this.mockmvc = MockMvcBuilders.standaloneSetup(datacontroller).build();		
//		this.session = new  MockHttpSession();
//		//构造session 12001
//		//session.setAttribute("userId", "12001");
//		this.request = new MockHttpServletRequest();
//	}
//	
//	@Test
//	public void ctest()throws Exception{
////						.param("prePassword", "654321")
////						.param("password", "123456")
//		ResultActions resultaction =	this.mockmvc.perform(MockMvcRequestBuilders.post("/data/newdata")
//						.session(session)).andExpect(status().isOk()).andDo(print());
//		MvcResult mvcresult = resultaction.andReturn();
//		String c=mvcresult.getResponse().getContentAsString();
//		System.out.println(c);
//				
//	}
//	
//	
//	
//	
//	
//}
