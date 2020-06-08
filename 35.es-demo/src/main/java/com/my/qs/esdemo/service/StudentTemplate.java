package com.my.qs.esdemo.service;

import java.util.List;

public class StudentTemplate {
	private String name;
	private Integer age;
	private List<String> hobby;
	private String birth;

	@Override
	public String toString() {
		return "StudentTemplate{" +
			"name='" + name + '\'' +
			", age=" + age +
			", hobby=" + hobby +
			", birth=" + birth +
			'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
}
