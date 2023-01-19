package com.jwl.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwl.spring.ex.mybatis.bo.ReviewBO;
import com.jwl.spring.ex.mybatis.model.Review;

@RestController
@RequestMapping("/mybatis")
public class ReviewController {
	
	@Autowired
	ReviewBO reviewBO;
	@RequestMapping("/ex01")
	//annotation 을 통해 요청을 받는다
	// id 라는 파라미터로 전달 받는것을 id 로 전달 한다
	public Review review(@RequestParam("id") int id) {
	//@RequestParam(value="id", required= false)int id -> request 400 error 사라진다
	//@RequestParam(value="id", defaultValue="3")int id -> id 전달되지않으면 default 값으로 전달 된다.
		
		// 3 번 을 전달한다
		Review review = reviewBO.getReview(id);
		
		return review;
	}
	
	//Insert 진행 데이터는 컨트롤러에서 직접 부여

	@RequestMapping("/ex02")
	public String addReview() {
		int count = reviewBO.addReviewAsField(4, "콤비네이션피자", "김인규", 4.5, "할인도 많이 받고 잘 먹었습니다.");
		return "삽입결과" + count;
	}
	
	@RequestMapping("/ex03")
	public String addReview_2() {
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("이재원");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클이다!!");
		
		int count = reviewBO.addReview(review);
		
		return "실행 결과" + count;
	}
}
