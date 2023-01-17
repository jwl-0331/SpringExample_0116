package com.jwl.spring.ex.lifecycle.model;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Person {

	//이름, 나이
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
