package com.ssj.springstudy.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssj.springstudy.login.model.Login;
import com.ssj.springstudy.login.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public Login loginCheck(String id, String pwd) {
		Login login = loginRepository.selectUser(id);
		
		String inputId = id;
		String inputPwd = pwd;
		if (login != null) {
			String getId = login.getId();
			String getPwd = login.getPwd();
			
			if(getId != null&& inputId.equals(getId)) {
				if(inputPwd.equals(getPwd)) {
					login.setLogin(true);
				} else {
					login.setLogin(false);
				}
			}
			return login;
		}
		return null;
	} 
}
