package com.jwl.spring.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jwl.spring.ex.database.model.UsedGoods;

//인터페이스 생성
//데이터 베이스 관련
@Repository
public interface UsedGoodsDAO {

	// used_goods 테이블 전체 조회
	// 다 조회할것이라 전달 받을것이 없다
	//메소드가 호출되면 쿼리가 실행되어야 한다
	// Mybatis frame work 를 통해 쿼리를 연결하는 과정이 실시된다
	// 알아서 List 로 만들어진다
	public List<UsedGoods> selectUsedGoodsList();
}
