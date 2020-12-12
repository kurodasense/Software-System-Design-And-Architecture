package mymvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mymvc.po.User;
import mymvc.service.UserService;


@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(User user, HttpSession session, Model model) {
		if(userService.login(user)) {
			session.setAttribute("user", user);
			return "returnMessage";//跳转到主页
		}else {
			session.setAttribute("message", "用户名或密码错误");
			return "redirect:/Login.jsp";
		}
	}
	
}
