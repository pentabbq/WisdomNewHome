/**
* @Title: userMapper.java
* @Package com.wisdom.dao
* @Description: 用户map映射
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.dao;



import org.apache.ibatis.annotations.Param;


import com.wisdom.bean.User;


public interface UserMapper {


	/**   
	 * @Title: selectUserById   
	 * @Description: 登陸驗證/查詢用戶詳情/二次登陸建立會話  通过userId取设备数据 
	 * @param userId
	 * @return User       
	 */
	User selectUserById(String userId);


	/**   
	 * @Title: update   
	 * @Description: 修改用戶密碼 parameter是注入數據庫中的參數
	 * @param password
	 * @param userId
	 * @return boolean       
	 */
	boolean update(@Param("password")String password,@Param("userId")String userId);
		
	
	//對象方式
	User queryUserById(User user);
	
	void registerByUseridAndPassword(@Param("userId")String userid,@Param("password")String password);
	

	
	
}
