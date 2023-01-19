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
	
	//id 저절로 creat update 정해진값
	public int addReviewAsField(int storeId, String menu, String userName, double point, String review) {
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	//객체를 전달 받는다
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);	
	}
}
