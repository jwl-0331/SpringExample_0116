package com.jwl.spring.ex.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jwl.spring.ex.jsp.dao.NewUserDAO;
import com.jwl.spring.ex.jsp.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired
	private NewUserDAO newUserDAO;
	public NewUser getLastUser() {
		return newUserDAO.selectLastUser();
	}
	
	public int addUser(String name
			, String birthday
			, String email
			, String introduce) {
		return newUserDAO.insertUser(name, birthday, email, introduce);
		
	}
	
}
