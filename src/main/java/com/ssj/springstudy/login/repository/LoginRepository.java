package com.ssj.springstudy.login.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssj.springstudy.login.model.Login;

@Repository
public class LoginRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//아이디가 있는지만 확인하면 되는건지.
	public Login selectUser(String id) {
		Login login = sqlSession.selectOne("login.select", id);
		return login;
	}
}
