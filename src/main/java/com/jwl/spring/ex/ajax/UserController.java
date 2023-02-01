package com.jwl.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwl.spring.ex.ajax.bo.UserBO;
import com.jwl.spring.ex.jsp.model.NewUser;

@Controller
@RequestMapping("/ajax/user")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<NewUser> userList = userBO.getUserList();
		//여기서 데이터 베이스를 가져와서 조회한다
		
		model.addAttribute("userList",userList);
		
		return "ajax/user/list";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name")String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("email") String email) {
		int count = userBO.addUser(name, yyyymmdd, email);
		
		// 인서트 성공 여부를 데이터로 만든다.
		// {"result":"success"}
		// {"result":"fail"}
		Map<String, String> result =new HashMap<>();
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
		//return "redirect:/ajax/user/list";
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/user/input";
	}
	
	//email 주소를 전달받고 , 해당주소가 new_user 테이블에 존재하는지 확인 API
	// email 중복 여부 확인 API
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String,Boolean>isDuplicateEmail(@RequestParam("email")String email) {
		
		//중복-{"is_duplicate":true}
		//중복x ={"is_duplicate":false}
		Map<String, Boolean> result = new HashMap<>(); 
		if(userBO.isDuplicateEmail(email)) { //중복된경우
			result.put("is_duplicate", true);
		}else {
			result.put("is_duplicate", false);
		}
		return result;
		
	}
}
