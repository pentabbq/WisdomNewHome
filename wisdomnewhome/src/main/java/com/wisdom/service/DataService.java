/**
* @Title: DataService.java
* @Package com.wisdom.service
* @Description: TODO(用一句话描述该文件做什么)
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.service;

import java.util.List;
import java.util.Map;


public interface DataService {
		
	/**   
	 * @Title: selectLastData   
	 * @Description: 取出历史时间最新的五条数据   
	 * @param map
	 * @return List<Map>       
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> selectLastData(Map map);
	
	/**   
	 * @Title: selectAverageDayData   
	 * @Description: 某天每小时的甲醛平均数统计
	 * @param map
	 * @return List<Float>       
	 */
	public List<String> selectAverageDayData(Map<String,String> map);
	
	/**   
	 * @Title: selectAverageMouthData   
	 * @Description: 某段时间的甲醛平均数统计 
	 * @param map
	 * @return List<String>       
	 */
	public List<String> selectAverageMonthData(Map<String,String> map);
	
	/**   
	 * @Title: selectNewData   
	 * @Description: 取出最新时间的数据 
	 * @param map
	 * @return Map<?,?>       
	 */
	public Map<?, ?> selectNewData(Map<Object, Object> map);
	

	
	
	
}
