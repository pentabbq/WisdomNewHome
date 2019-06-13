/**
* @Title: UserService.java
* @Package com.wisdom.service
* @Description: 用户服务层逻辑
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.service;

import java.util.Map;

import com.wisdom.bean.User;

/**
* @ClassName: UserService
* @Description: 用户服务层逻辑服务
* @author Jyg
* @date 2018年5月2日
*
*/


public interface UserService {
	//parameter
	//二次登陸建立會話
	public User selectById(String userId);
	//檢查用戶信息
	public User selectUser(String userId);
	//检验登陆
	public User logIn(String userId,String password);
	//更新用戶信息
	public Map<?, ?> update(String userId,String prepassword,String password);
	
	//對象
	void regist(User user);

	//查用戶信息
	public User queryUserById(User user);






}
