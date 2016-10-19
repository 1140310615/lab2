package com.lining.struts2;

public class author {
	private String authorid;
	private String name;
	private String age;
	private String country;
	author(){}
	author(String authorid, String name,
		 String age, String country){
		this.authorid = authorid;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public String getAuthorid() {
		return authorid;
	}
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
