/**
* @Title: DataTest.java
* @Package wisdomnewhome
* @Description: TODO(用一句话描述该文件做什么)
* @author Jyg
* @date 2018年5月23日
* @version V1.0
*/
package wisdomnewhome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wisdom.dao.DataMapper;
import com.wisdom.service.DataService;

/**
* @ClassName: DataTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Jyg
* @date 2018年5月23日
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring-mybatis.xml")  
public class DataTest {
	static ApplicationContext context =null;
	
	@Autowired
	public DataMapper datamapper;
	@Autowired
	public DataService dataservice;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
			}
	@Test
	public void testAverage() {
		Map map =new HashMap<>();
		map.put("userId", "12001");
		map.put("averageDayDate", "2018-05-23");
		List<Map> a= datamapper.selectAverageDayData(map);
		System.out.println(a);
		List<String> b = dataservice.selectAverageDayData(map);
		System.out.println(b);
		
//		Map mouthmap = new HashMap<>();
//		mouthmap.put("userId", "12001");
//		mouthmap.put("beginDate", "2018-05-01");
//		mouthmap.put("endDate", "2018-05-31");
//		List<String> c = dataservice.selectAverageMonthData(mouthmap);
//		System.out.println(c);
		
		
//		Map lastmap = new HashMap<>();
//		lastmap.put("userId", "12001");
//		List<Map> b = dataservice.selectLastData(lastmap);	
//		System.out.println(b);
	}
	
}
