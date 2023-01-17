package com.jwl.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.spring.ex.mybatis.dao.ReviewDAO;
import com.jwl.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	// id 가 3 인 데이터 조회
	public Review getReview(int id) {
		//조회하고 싶은 숫자를 넣는다 BO 도 parameter 로 받는다
		Review review = reviewDAO.selectReview(id);
		return review;
	}
}
