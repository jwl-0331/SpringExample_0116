package com.jwl.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jwl.spring.ex.jsp.bo.NewUserBO;
import com.jwl.spring.ex.jsp.model.NewUser;

@Controller
@RequestMapping("/jsp/user")
public class NewUserController {
	
	//가장 최근꺼 가져오기
	//jsp -> jsp 경로 return
	@Autowired
	private NewUserBO newUserBO;
	@GetMapping("/lastuser")
	public String lastUser(Model model) {
		
		NewUser lastUser = newUserBO.getLastUser();
		// lastUSer 객체를 jsp 사용하기위해 Model 객체가 필요하다
		model.addAttribute("user", lastUser);
		model.addAttribute("title", "최근 사용자");
		//prefix , surfix 미리 설정되있다 
		return "jsp/lastuser";
	}
	
	// POST 파라미터가 주소에 노출 되지않는다 , GET
	//@RequestMapping(path= "/add", method=RequestMethod.POST)
	@PostMapping("/add")
	public String addUser(
			@RequestParam(value="name")String name	
			,@RequestParam(value="birthday")String birthday
			,@RequestParam("email")String email
			,@RequestParam("introduce")String introduce
			, Model model){
		
		//int count = newUserBO.addUser(name,birthday,email,introduce);
		
		//return "추가 완료 : " + count;
		
		//객체 형태로 전달 받아서 추가한것을 보여준다 add 하고 나서 id 를 얻어온다
		NewUser user = new NewUser();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce); 
		
		//힙에 객체가 생성되어서 그 객체를 계속 쳐다보고있다 user도 그 객체를 쳐다보고있다
		//add 한것을 쳐다본다
		newUserBO.addUserByObject(user);
		
		model.addAttribute("user",user);
		//jsp 폴더와 연동
		return "jsp/lastuser";
	}
	
	
	
	//입력화면 -> jsp 경로 페이지 html 을 보여주는것이다 post를 쓸이유가 없다 parameter 전달 없다
	//Get   Post
	@GetMapping("/input")
	public String userInput() {
		return "jsp/userinput";
	}
}
