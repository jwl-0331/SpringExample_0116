package com.jwl.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwl.spring.ex.database.bo.UsedGoodsBO;
import com.jwl.spring.ex.database.model.UsedGoods;

//Controller 역할
//request 를 전달 받아서 처리하고
//response를 정돈하는 역할 (이외의 역할 수행 x)
@Controller
//usedgoods data json 으로 조회
//조회는 다른 class에 시킨다.
//controller는 service를 거쳐야한다 repository 접근 x
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@ResponseBody
	@RequestMapping("/database/ex01")
	public List<UsedGoods> ex01() {
		
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;
	}
}
