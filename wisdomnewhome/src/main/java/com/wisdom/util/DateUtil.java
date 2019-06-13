/**
* @Title: DateUtil.java
* @Package com.wisdom.util
* @Description: TODO(用一句话描述该文件做什么)
* @author Jyg
* @date 2018年5月23日
* @version V1.0
*/
package com.wisdom.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
* @ClassName: DateUtil
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Jyg
* @date 2018年5月23日
*
*/
public class DateUtil {
	
	/**   
	 * @Title: formatDate   
	 * @Description: 修正日期格式   
	 * @param sql.date
	 * @param format
	 * @return String       
	 */
	public static String formatDate(Date date,String format) {
		String result="";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date != null) {
			result = sdf.format(date);
		}
		return result;		
	}
	

	
}
