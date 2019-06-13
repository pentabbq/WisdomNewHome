/**
* @Title: DateDetail.java
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
* @ClassName: DateDetail
* @Description: 测得的各项数据
* @author Jyg
* @date 2018年5月2日
*
*/
public class DataDetail implements Serializable {
	
	/**
	* @Fields field:field:序列化初始化
	*/
	private static final long serialVersionUID = 1L;
	
	
	private Integer dataId;
	private double temperature;
	private double humidity;
	private double formaldehyde;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date  dDate;
	private String averageDayDate;
	private String beginDate;
	private String endDate;
	
	
	/**
	 * @return the beginDate
	 */
	public String getBeginDate() {
		return beginDate;
	}
	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the averageDayDate
	 */
	public String getAverageDayDate() {
		return averageDayDate;
	}
	/**
	 * @param averageDayDate the averageDayDate to set
	 */
	public void setAverageDayDate(String averageDayDate) {
		this.averageDayDate = averageDayDate;
	}
	public DataDetail() {
		
	}
	/**
	 * @return the formaldehyde
	 */
	public double getFormaldehyde() {
		return formaldehyde;
	}
	/**
	 * @param formaldehyde the formaldehyde to set
	 */
	public void setFormaldehyde(double formaldehyde) {
		this.formaldehyde = formaldehyde;
	}
	/**
	 * @return the dataid
	 */
	public Integer getDataid() {
		return dataId;
	}
	/**
	 * @param dataid the dataid to set
	 */
	public void setDataid(Integer dataid) {
		this.dataId = dataid;
	}
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the ddate
	 */
	public Date getDdate() {
		return dDate;
	}
	/**
	 * @param ddate the ddate to set
	 */
	public void setDdate(Date ddate) {
		this.dDate = ddate;
	}
	
	
	
	
}
