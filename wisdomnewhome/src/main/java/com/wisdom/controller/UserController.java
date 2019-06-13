/**
* @Title: UserController.java
* @Package com.wisdom.controller
* @Description: 用户控制层逻辑
* @author Jyg
* @date 2018年5月5日
* @version V1.0
*/
package com.wisdom.controller;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisdom.bean.User;
import com.wisdom.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	//日志文件
	private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	
	/**   
	 * @Title: logIn   
	 * @Description: 登陆绑定验证   
	 * @param userId
	 * @param password
	 * @param session
	 * @return Map<String,Serializable>       
	 */
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Serializable> logIn(@RequestParam("userId") String userId,@RequestParam("password") String password,HttpSession session) {
		User resUser =userService.logIn(userId, password);	
		Map<String, Serializable> map = new HashMap<>();
		session.setMaxInactiveInterval(30*60);
		if(resUser != null) {
		session.setAttribute("userId", resUser.getUserid());	
		map.put("userId", resUser.getUserid());
		map.put("sessionId", session.getId());
		map.put("states", 1);
		logger.info("用户设备："+userId+" 绑定成功并登陆，当前sessionId为："+session.getId());		
		return map;
	
		}else {
		map.put("states", 0);
		logger.info("用户设备："+userId+" 绑定失败");
		return map;
		}	
	
	}
	
	
	/**   
	 * @Title: selectById   
	 * @Description: 二次校验验证上线 
	 * @param userId
	 * @param session
	 * @return Map<String,Serializable>       
	 */
	@RequestMapping(value ="/selectbyid",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Serializable> selectById(@RequestParam("userId") String userId,HttpSession session) {
		User resUser = userService.selectById(userId);
		Map<String, Serializable> map =new HashMap<>();
		session.setMaxInactiveInterval(30*60);
		if(resUser != null) {
			//session中存入userId
			session.setAttribute("userId", resUser.getUserid());
			map.put("userId", resUser.getUserid());
			map.put("sessionId", session.getId());
			logger.info("用户设备："+userId+" 上线绑定，当前sessionId为："+session.getId());
			return map;
		}else {
			map.put("states", 0);
			logger.info("用户设备："+userId+" 上线绑定失败");
			return map;
		}
		
	}
	
	

	/**   
	 * @Title: selectUser   
	 * @Description: 获取用户设备详情
	 * @param userId
	 * @param request
	 * @return Map<Object,Object>       
	 */
	@RequestMapping(value="/userdetail" , method =RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> selectUser(@RequestParam("userId") String userId,HttpServletRequest request) {		
		User quser = userService.selectUser(userId);
		Map<Object, Object> map  =new HashMap<>();
		if(quser != null) {
		map.put("userId", quser.getUserid());
		map.put("userName", quser.getUsername());
		map.put("version", quser.getVersion());
		map.put("osVersion", quser.getOsVersion());
		map.put("pDate", quser.getpDate());
		logger.info("用户设备: "+userId+" 查看设备详情");
		return map;
		}else {
			map.put("queryState", "fail");
			logger.info("用户设备："+userId+" 设备详情查看失败");
			return map;
		}				
	}
	     

	/**   
	 * @Title: update   
	 * @Description: 修改用户密码  双参数   
	 * @param prePassword
	 * @param password
	 * @param request
	 * @return Map<?,?>       
	 */
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Map<?, ?> update(@RequestParam("prePassword")String prePassword,@RequestParam("password")String password,HttpServletRequest request) {
		Map<String, String> rmap = new HashMap<>();
		if(request.getSession().getAttribute("userId") != null) {		
			String userId = request.getSession().getAttribute("userId").toString();				
			return userService.update(userId, prePassword, password);			
		}else{	
			rmap.put("sessionUserId",request.getSession().getAttribute("userId").toString());
			rmap.put("update", "fail");
			return rmap;			
		}		
	}
	
	
	/**   
	 * @Title: updateUser   
	 * @Description: 更新用户设备密码  
	 * @param userId
	 * @param prePassword
	 * @param password
	 * @return Map<?,?>       
	 */
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	@ResponseBody
	public Map<?, ?> updateUser(@RequestParam("userId")String userId,@RequestParam("prePassword")String prePassword,@RequestParam("password")String password){
		Map<String, String> remap= new HashMap<>();
		if(userId != null) {
			logger.info("用户："+userId+" 修改密码成功");
			return userService.update(userId, prePassword, password);	
		}else {
			remap.put("update", "fail");
			logger.info("用户："+userId+" 修改密码失败");
			return remap;
		}
		
	}
	
}
