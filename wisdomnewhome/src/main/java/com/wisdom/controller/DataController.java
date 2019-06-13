/**
* @Title: DataController.java
* @Package com.wisdom.controller
* @Description: 数据展示controller逻辑
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.controller;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import com.wisdom.service.DataService;


@Controller
@RequestMapping("/data")
public class DataController {
		//日志配置
		private static Logger logger = LoggerFactory.getLogger(DataController.class);
		
		@Autowired
		private DataService dataService;
		
		/**   
		 * @Title: selectLastData   
		 * @Description: 查看历史五条数据
		 * @param map
		 * @param request
		 * @return List<Map>       
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value ="/lastdata",method=RequestMethod.POST)
		@ResponseBody
		public List<Map> selectLastData(@RequestBody Map map,HttpServletRequest request){
			if(map.get("userId") != null) {
			logger.info("用户设备："+map.get("userId")+" 展示最新五条数据");
			return dataService.selectLastData(map);
			}else {
				Map rmap = new HashMap<>();
				logger.warn("用户设备："+map.get("userId")+" 展示历史数据故障");
				return (List<Map>) rmap.put("querystate", "fail");
			}
		}
		
		/**   
		 * @Title: selectAvgDay   
		 * @Description: 按小时统计某一天甲醛的平均数值
		 * @param map
		 * @param request
		 * @return List<String>       
		 */
		@RequestMapping(value ="/dayaverage", method=RequestMethod.POST)
		@ResponseBody
		public List<String> selectAvgDay(@RequestBody Map<String,String> map,HttpServletRequest request){
			if(map.get("userId")!=null && map.get("averageDayDate")!=null) {
				logger.info("用户设备： "+map.get("userId")+" 显示折线图");
				return dataService.selectAverageDayData(map);				
			}else {
				List<String> redata = new ArrayList<>();
				logger.warn("用户设备："+map.get("userId")+" 展示历史数据故障");
				redata.add("fail");
				return redata;   
			}
		}

		/**   
		 * @Title: selectAvgMouth   
		 * @Description: 按天统计甲醛平均数值
		 * @param map
		 * @param request
		 * @return List<String>       
		 */
		@RequestMapping(value ="/monthaverage", method=RequestMethod.POST)
		@ResponseBody
		public List<String> selectAvgMonth(@RequestBody Map<String,String> map,HttpServletRequest request){
			if(map.get("userId")!=null && map.get("beginDate")!=null && map.get("endDate")!=null) {
				logger.info("用户设备： "+map.get("userId")+" 显示折线图");
				return dataService.selectAverageMonthData(map);			
			}else {
				List<String> redata = new ArrayList<>();
				logger.warn("用户设备："+map.get("userId")+" 展示历史数据故障");
				redata.add("fail");
				return redata;   
			}
		}
		
		/**   
		 * @Title: selectNewDataBy   
		 * @Description: 查看当前用户的当前数据信息 
		 * @param request
		 * @return Map<?,?>       
		 */		
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/newdata",method =RequestMethod.POST)
		@ResponseBody
		public Map<?, ?> selectNewData(@RequestBody Map<Object, Object> map,HttpServletRequest request){
			if(map.get("userId") != null) {			
			logger.info("用户："+map.get("userId")+" 查询当前最新数据");			
			return dataService.selectNewData(map);
			}else {
				@SuppressWarnings("rawtypes")
				Map rmap =new HashMap<>();
				logger.warn("用户设备："+map.get("userId")+" 展示最新数据故障");
				return (Map<?, ?>) rmap.put("querystate", "fail");
			}
		}
		
		
		
}
