package com.jwl.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.spring.ex.database.dao.UsedGoodsDAO;
import com.jwl.spring.ex.database.model.UsedGoods;


//로직 (if ,for , 연산 과정 등등 진행)
//controller 에서 database 조회
//Repository 한테 시킨다. (데이터 베이스)
@Service
public class UsedGoodsBO {
	
	//spring 이 알아서 객체를 생성해서 진행한다 - 무분별한 객체 생성을 방지
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	//used_goods 테이블을 전체 데이터 조회 기능
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		
		// for 문같은것이 여기에 들어간다
		
		return usedGoodsList;
	}
}
