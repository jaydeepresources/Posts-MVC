package com.my.site;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.PostDAOImpl;
import model.Post;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	PostDAOImpl impl = new PostDAOImpl();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("serverTime", new Date());
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user(@RequestParam(value = "userName") String userName) {
		ModelAndView view = new ModelAndView("user");
		view.addObject("userName", userName);
		return view;
	}

	@RequestMapping("/add")
	public ModelAndView addPost() {

		return new ModelAndView("add", "command", new Post());
	}
	
		// @RequestMapping(value = "/add", method = RequestMethod.GET)
	/*
	 * public ModelAndView addPost(@RequestParam(value = "title") String title,...)
	 * {
	 * 
	 * int res = impl.add(new Post(0,title,body));
	 * 
	 * String result = (res == 1) ? "post added" : "post couldn't be added";
	 * ModelAndView view = new ModelAndView("result"); 
	 * view.addObject("result",result); 
	 * return view;
	 */

	@RequestMapping(value = "/addpost", method = RequestMethod.POST)
	public ModelAndView addPost(@ModelAttribute("post") Post post) {
		System.out.println(post);
		ModelAndView view = new ModelAndView("/result");

		int res = impl.insert(post);

		String result = (res == 1) ? "post added" : "post couldn't be added";

		view.addObject("result", result);
		return view;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam(value = "id") int id) {

		int res = impl.delete(id);

		String result = (res == 1) ? "post deleted" : "post couldn't be deleted";

		ModelAndView view = new ModelAndView("result");
		view.addObject("result", result);
		return view;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewPosts() {

		List<Post> list = null ;
		try {
			list = impl.view();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView view = new ModelAndView("view_all");
		view.addObject("list", list);
		return view;
	}

}
