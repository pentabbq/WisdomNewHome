/**
* @Title: User.java
* @Package com.wisdom.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author Jyg
* @date 2018年5月2日
* @version V1.0
*/
package com.wisdom.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @ClassName: User
* @Description: 用户表
* @author Jyg
* @date 2018年5月2日
*
*/
public class User implements Serializable{

	/**
	* @Fields field:field:序列化初始化
	*/
	private static final long serialVersionUID = 1L;
	
	
	
	private String userId;
	private String openId;
	private String userName;
	private String password;
	private String version;
	private String osVersion;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date pDate;
	
	
	    /**  
	    * 创建一个新的实例 User.  
	    *    
	    */  
	public User() {
		super();
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}
	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	/**
	 * @return the pDate
	 */
	public Date getpDate() {
		return pDate;
	}
	/**
	 * @param pDate the pDate to set
	 */
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userId
	 */
	public String getUserid() {
		return userId;
	}
	/**
	 * @param userid the userId to set
	 */
	public void setUserid(String userid) {
		this.userId = userid;
	}
	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openId;
	}
	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openId = openid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return userName;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.userName = username;
	}
	
	
	
}
