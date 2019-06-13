///**
//* @Title: DateController.java
//* @Package TestController
//* @Description: TODO(用一句话描述该文件做什么)
//* @author Jyg
//* @date 2018年5月24日
//* @version V1.0
//*/
//package TestController;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.wisdom.controller.DataController;
//
///**
//* @ClassName: DateController
//* @Description: TODO(这里用一句话描述这个类的作用)
//* @author Jyg
//* @date 2018年5月24日
//*
//*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
//public class DateController {
//	private MockMvc mockmvc;
//	
//	@Autowired
//	private DataController datacontroller;
//	
//	@Before
//	public void setup() {
//		//初始化mockmvc對象
//		mockmvc = MockMvcBuilders.standaloneSetup(datacontroller).build();		
//	}
//	
//	@Test
//	public void dataTest() throws Exception {
//		ResultActions resultaction = this.mockmvc.perform(MockMvcRequestBuilders.patch("/data/dayaverage").param("userId", "12001").param("averageDayDate", "2018-05-03"));
//		
//		MvcResult mvcresult = resultaction.andReturn();
//		
//		System.out.println(mvcresult);
//	}
//	
//}
