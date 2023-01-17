package com.jwl.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwl.spring.ex.mybatis.bo.ReviewBO;
import com.jwl.spring.ex.mybatis.model.Review;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewBO reviewBO;
	@RequestMapping("/mybatis/ex01")
	//annotation 을 통해 요청을 받는다
	// id 라는 파라미터로 전달 받는것을 id 로 전달 한다
	public Review review(@RequestParam("id") int id) {
	//@RequestParam(value="id", required= false)int id -> request 400 error 사라진다
	//@RequestParam(value="id", defaultValue="3")int id -> id 전달되지않으면 default 값으로 전달 된다.
		
		// 3 번 을 전달한다
		Review review = reviewBO.getReview(id);
		
		return review;
	}
}
