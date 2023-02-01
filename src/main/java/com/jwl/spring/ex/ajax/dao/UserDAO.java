package com.jwl.spring.ex.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwl.spring.ex.jsp.model.NewUser;

@Repository
public interface UserDAO {
	
	public List<NewUser> selectUserList();
	
	public int insertUser(
			@Param("name")String name
			,@Param("yyyymmdd") String yyyymmdd
			,@Param("email") String email);
	
	public int selectCountEmail(@Param("email")String email);
}
