package com.ssj.springstudy.login.controller;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssj.springstudy.board.model.Board;
import com.ssj.springstudy.board.service.BoardService;
import com.ssj.springstudy.login.model.Login;
import com.ssj.springstudy.login.service.LoginService;
import com.ssj.springstudy.sample.model.Sample;

@Controller
@RequestMapping("/login")

public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mow = new ModelAndView("/login/loginForm");
		return mow;
	}
	
	//@RequestParam(value="id" , required = false) String id, @RequestParam(value="pwd" , required = false) String pwd
	
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		ModelAndView mov = new ModelAndView("/login/loginOk");
		Login login = loginService.loginCheck(id, pwd);
		if (login != null) {
			if(login.getIsLogin() == true) {
				System.out.println(login.getIsLogin() + login.getId());
				session.setAttribute("login", login);
				mov.setViewName("/login/loginOk");
			} else if (login.getIsLogin() == false) {
				mov.setViewName("/login/loginForm");
			}
		} else {
			mov.setViewName("/login/loginForm");
		}
		return mov;
	}
}
