package com.jwl.spring.ex.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jwl.spring.ex.ajax.bo.UserBO;
import com.jwl.spring.ex.jsp.model.NewUser;

@Controller
@RequestMapping("/ajax/user")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	@GetMapping("list")
	public String userList(Model model) {
		
		List<NewUser> userList = userBO.getUserList();
		//여기서 데이터 베이스를 가져와서 조회한다
		
		model.addAttribute("userList",userList);
		
		return "ajax/user/list";
	}
	
	@GetMapping("/add")
	public String addUser(
			@RequestParam("name")String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("email") String email) {
		int count = userBO.addUser(name, yyyymmdd, email);
		
		return "redirect:/ajax/user/list";
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/user/input";
	}
}
