/**
* @Title: DataServiceImpl.java
* @Package com.wisdom.serviceimpl
* @Description: 数据查询业务逻辑
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wisdom.dao.DataMapper;
import com.wisdom.service.DataService;


/**
* @ClassName: DataServiceImpl
* @Description:数据查询业务逻辑层
* @author Jyg
* @date 2018年5月2日
*
*/


@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {
	//日志消息
	private static Logger logger  = LoggerFactory.getLogger(DataServiceImpl.class);
	
	@Autowired
	private DataMapper dataMapper;
		
	    /* (非 Javadoc)  
	    * <p>Title: selectLastData</p>  
	    * <p>Description: 根据时间顺序查询最新的历史五条数据</p>  
	    * @param map
	    * @return  
	    * @see com.wisdom.service.DataService#selectLastData(java.util.Map)  
	    */  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> selectLastData(Map map) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map> datas = dataMapper.selectLastData(map);
		for(Map<String, String> data:datas) {
			try {
				if (data.get("dDate") != null) {
					String formattedDate = formatter.format(data.get("dDate"));
					data.put("dDate",formattedDate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return datas;
		
	}

	/* (非 Javadoc)  
	 * <p>Title: selectAverageDayData</p>  
	 * <p>Description：某天甲醛平均数查询 </p>  
	 * @param map
	 * @return  
	 * @see com.wisdom.service.DataService#selectAverageDayData(java.util.Map)  
	 */  
	@Override
	public List<String> selectAverageDayData(Map<String,String> map) {
		// TODO Auto-generated method stub
		List<Map<String, String>> datas = dataMapper.selectAverageDayData(map);
		List<String> reavg = new ArrayList<>();
		for(Map<?, ?> data:datas) {
			reavg.add(data.get("avg").toString());
		}		
		return reavg;
	}
	
	    /* (非 Javadoc)  
	    * <p>Title: selectAverageMouthData</p>  
	    * <p>Description: </p>  
	    * @param map
	    * @return  
	    * @see com.wisdom.service.DataService#selectAverageMouthData(java.util.Map)  
	    */  
	@Override
	public List<String> selectAverageMonthData(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Map<String, String>> datas = dataMapper.selectAverageMonthData(map);
		List<String> reavg = new ArrayList<>();
		for(Map<?, ?> data:datas) {
			reavg.add(data.get("avg").toString());
		}		
		return reavg;
	}

	    /* (非 Javadoc)  
	    * <p>Title: selectNewData</p>  
	    * <p>Description:查询最新的数据信息 </p>  
	    * @param map
	    * @return  
	    * @see com.wisdom.service.DataService#selectNewData(java.util.Map)  
	    */  
	@Override
	public Map<?, ?> selectNewData(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		
		Map<String, Object> remap = dataMapper.selectNewData(map);	 
		 if((double)remap.get("formaldehyde")<=0.08) {
			 remap.put("quality", "comfort");
			 logger.info("当前空气质量指数为舒适");
			 return remap;
		 }else if((double)remap.get("formaldehyde")>0.08&&(double)remap.get("formaldehyde")<=0.10){
			 remap.put("quality", "normal");
			 logger.info("当前空气质量指数为正常");
			 return remap;			 
		 }else {
			 remap.put("quality", "overproof");
			 logger.info("当前空气质量指数为超标");
			 return remap;
		 }
		 
		
	}






	
}
