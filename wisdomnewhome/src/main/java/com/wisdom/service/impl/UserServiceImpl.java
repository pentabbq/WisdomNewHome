/**
* @Title: UserServiceImpl.java
* @Package com.wisdom.serviceimpl
* @Description: 用户服务层逻辑实现类
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisdom.bean.User;
import com.wisdom.dao.UserMapper;
import com.wisdom.service.UserService;

/**
* @ClassName: UserServiceImpl
* @Description: 用户服务层逻辑实现类
* @author Jyg
* @date 2018年5月2日
*
*/
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	//日志消息
	private static Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private  UserMapper userMapper;

	    /* (非 Javadoc)  
	    * <p>Title: selectById</p>  
	    * <p>Description:二次登陆验证 </p>  
	    * @param userId
	    * @return  
	    * @see com.wisdom.service.UserService#selectById(java.lang.String)  
	    */  
	public User selectById(String  userId) {
		// TODO Auto-generated method stub
		User quser = userMapper.selectUserById(userId);
		return quser;		
	}

	
	public User queryUserById(User user) {
		// TODO Auto-generated method stub
		User data  = userMapper.queryUserById(user);
		if (data != null && data.getPassword().equals(user.getPassword())) {
			return data;
		}
		logger.warn("查询用户方法出现问题");
		return null;
	
	}



	    /* (非 Javadoc)  
	    * <p>Title: logIn</p>  
	    * <p>Description:登陆绑定验证 </p>  
	    * @param userId
	    * @param password
	    * @return  
	    * @see com.wisdom.service.UserService#logIn(java.lang.String, java.lang.String)  
	    */  
	@Override
	public User logIn(String userId, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.selectUserById(userId);
		if(user !=null && user.getPassword().equals(password)) {
			return user;			
		}
		
		return null;
		
	}



	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		userMapper.registerByUseridAndPassword(user.getUserid(), user.getPassword());
	}


	



	//查看用戶詳情
	    /* (非 Javadoc)  
	    * <p>Title: selectUser</p>  
	    * <p>Description:查看用户设备详情 </p>  
	    * @param userId
	    * @return  
	    * @see com.wisdom.service.UserService#selectUser(java.lang.String)  
	    */  
	@Override
	public User selectUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(userId);
	}






	    /* (非 Javadoc)  
	    * <p>Title: update</p>  
	    * <p>Description:修改用户设备密码 </p>  
	    * @param userId
	    * @param prepassword
	    * @param password
	    * @return  
	    * @see com.wisdom.service.UserService#update(java.lang.String, java.lang.String, java.lang.String)  
	    */  
	@Override
	public Map<String, String> update(String userId,String prepassword,String password) {
		// TODO Auto-generated method stub
		Map<String, String> map= new HashMap<>();
		//進行密碼和賬戶校驗
		User checkuser = userMapper.selectUserById(userId);
		if(checkuser != null && checkuser.getPassword().equals(prepassword)){
			userMapper.update(password,userId);
			map.put("update", "success");
			return map;
		}else{
		 map.put("update", "fail");
		 return map;			
		}
		
	}



	
	
	
	
}
