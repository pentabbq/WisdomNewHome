/**
* @Title: dataMapper.java
* @Package com.wisdom.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.dao;

import java.util.List;
import java.util.Map;


/**
* @ClassName: dataMapper
* @Description: 测得数据映射接口
* @author Jyg
* @date 2018年5月2日
*
*/
public interface DataMapper {



	/**   
	 * @Title: selectLastData   
	 * @Description: 取出最新时间段的五条数据按照时间排序  
	 * @param map
	 * @return List<Map>       
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectLastData(Map<?, ?> map);

	
	/**   
	 * @Title: selectAverageDayData   
	 * @Description: 查询某天中每个小时中甲醛的平均值   
	 * @param map
	 * @return List<Float>       
	 */
	List<Map<String,String>> selectAverageDayData(Map<String,String> map);
	
	/**   
	 * @Title: selectAverageMouthData   
	 * @Description: 查询某一段时间的甲醛平均数  天为单位
	 * @param map
	 * @return List<Map<String,String>>       
	 */
	List<Map<String, String>> selectAverageMonthData(Map<String,String> map);

	/**   
	 * @Title: selectNewData   
	 * @Description: 取出最新时间的最新数据信息  
	 * @param map
	 * @return Map<String,Object>       
	 */
	Map<String, Object> selectNewData(Map<?, ?> map);
	

	
	
	
	
	
	
}
