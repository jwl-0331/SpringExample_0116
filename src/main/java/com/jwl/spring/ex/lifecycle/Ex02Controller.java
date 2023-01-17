package com.jwl.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Ex02Controller {


	@RequestMapping("/lifecycle/ex02")
	//경로 리턴 jsp : return String
	public String jspResponse() {
		
		return "lifecycle/ex02";
	}
}
