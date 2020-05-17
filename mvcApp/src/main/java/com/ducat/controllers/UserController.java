package com.ducat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducat.entities.User;
import com.ducat.repositories.UserDao;

@Controller
public class UserController {

	// UserDao is autowired
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	/*@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(
	@RequestParam	String name,
	@RequestParam	String mailId,
	@RequestParam	String password)
	{
		User user = new User();
		user.setName(name);
		user.setMailid(mailId);
		user.setPassword(password);
		userDao.save(user);
		return "registered";
	}*/
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute User user)
	{
		userDao.save(user);
		return "registered";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute User user, HttpSession session)
	{
		List<User> list= userDao.findByMailId(user.getMailId());
		if(!list.isEmpty())
		{
			User found = list.get(0);
			if(found.getPassword().equals(user.getPassword())) {
				// user is stored in the session
				session.setAttribute("user", found);
				
				return "dashboard";
			}
			else {
				return "relogin";
			}
		}
		return "relogin";
	}
}
