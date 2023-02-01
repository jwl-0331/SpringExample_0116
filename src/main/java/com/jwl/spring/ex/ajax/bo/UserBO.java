package com.jwl.spring.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.spring.ex.ajax.dao.UserDAO;
import com.jwl.spring.ex.jsp.model.NewUser;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	public List<NewUser> getUserList(){
		return userDAO.selectUserList();
	}
	
	public int addUser(
			String name
			, String yyyymmdd
			, String email) {
		return userDAO.insertUser(name, yyyymmdd, email);
	}
	
	//email 중복 여부 알려주는 기능
	public boolean isDuplicateEmail(String email) {
		int count = userDAO.selectCountEmail(email);
		
		//count 가 0 이면 중복아님  
		if(count == 0) {
			return false;
		}else{
			//0아니면 중복임
			return true;
		}
		
	}
}
