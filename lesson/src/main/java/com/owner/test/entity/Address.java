package com.owner.test.entity;

public class Address {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.id
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.userId
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.country
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private String country;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.province
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private String province;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.city
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private String city;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.street
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private String street;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test..address.createTime
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	private Integer createTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.id
	 * @return  the value of test..address.id
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.id
	 * @param id  the value for test..address.id
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.userId
	 * @return  the value of test..address.userId
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.userId
	 * @param userId  the value for test..address.userId
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.country
	 * @return  the value of test..address.country
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.country
	 * @param country  the value for test..address.country
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.province
	 * @return  the value of test..address.province
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.province
	 * @param province  the value for test..address.province
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.city
	 * @return  the value of test..address.city
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.city
	 * @param city  the value for test..address.city
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.street
	 * @return  the value of test..address.street
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.street
	 * @param street  the value for test..address.street
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setStreet(String street) {
		this.street = street == null ? null : street.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test..address.createTime
	 * @return  the value of test..address.createTime
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test..address.createTime
	 * @param createTime  the value for test..address.createTime
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test..address
	 * @mbggenerated  Wed Sep 11 11:25:53 CST 2019
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", country=").append(country);
		sb.append(", province=").append(province);
		sb.append(", city=").append(city);
		sb.append(", street=").append(street);
		sb.append(", createTime=").append(createTime);
		sb.append("]");
		return sb.toString();
	}
}