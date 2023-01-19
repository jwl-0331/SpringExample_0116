package com.jwl.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwl.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {
	//id 3인 데이터 조회 쿼리 부르기
	//List 가 아닌 객체 하나 return
	//메소드의 파라미터로 값을 보낸다
	// XML 은 다르게 받아들인다 -> annotation Param 변수를 입력해준다
	public Review selectReview(@Param("id")int id);
	
	//실행된 갯수가 return 된다
	public int insertReviewAsField(
			@Param("storeId")int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	public int insertReview(Review review);
	
}
