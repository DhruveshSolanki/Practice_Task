package com.miniproject.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miniproject.Model.Project;
import com.miniproject.Model.User;
import com.miniproject.Service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/loginprocess")
	public ModelAndView login(@RequestParam("uId") int id, @RequestParam("uPassword") String pswrd) {
		ModelAndView m = new ModelAndView();
		User u = this.adminService.toViewUserById(id);
		// =====Validate User===========
		if (u != null) {
			
			if (id==u.getuId() && pswrd.equals(u.getuPassword())) {
				if (u.getuRole().equalsIgnoreCase("admin")) {
					m.setViewName("redirect:/adminhome");
					return m;
				} else {
					m.setViewName("redirect:/assistanthome");
					return m;
				}
			} else {
				m.addObject("cl", "alert alert-danger ");
				m.addObject("msg", "Incorrect UserId or Password! ");
				m.setViewName("index");
				return m;
			}

		} else {
			m.addObject("cl", "alert alert-danger ");
			m.addObject("msg", "User Doesn't Exists!");
			m.setViewName("index");
			return m;
		}
	}

	@GetMapping("/adminhome")
	public ModelAndView adminHome() {

		List<Project> projects = this.adminService.toViewProject();
		ModelAndView m = new ModelAndView();
		m.addObject("projects", projects);
		m.setViewName("admin");
		return m;
	}

	@GetMapping("/toaddproject")
	public String toAddProject(Model m) {
		m.addAttribute("title", "Add");
		m.addAttribute("action", "addproject");
		return "addproject";
	}

	@PostMapping("/addproject")
	public ModelAndView addProject(@ModelAttribute Project project) {
		int id;
		ModelAndView m = new ModelAndView();
		id = this.adminService.toAddProject(project);
		if (id == 0) {
			m.addObject("cl", "alert alert-danger ");
			m.addObject("msg", "Error Adding Project");
			m.setViewName("addproject");
		} else {
			m.setViewName("redirect:/adminhome");
		}
		return m;
	}

	@GetMapping("/deleteproject/{pId}")
	public String deleteProject(@PathVariable("pId") int id) {
		this.adminService.toDeleteProject(id);
		return "redirect:/adminhome";
	}

	@GetMapping("/toupdateproject/{pId}")
	public String toUpdateProject(@PathVariable("pId") int id, Model m) {

		Project p = this.adminService.toViewProjectById(id);
		m.addAttribute("p", p);
		m.addAttribute("title", "Update");
		m.addAttribute("action", "updateproject");
		return "addproject";
	}

	@PostMapping("/updateproject/{pId}")
	public String updateProject(@ModelAttribute Project project) {
		int id = this.adminService.toEditProject(project);
		if (id == 0) {
			return "error";
		} else {
			return "redirect:/adminhome";
		}
	}

	// ===============User Handlers================

	@GetMapping("/assistantdetails")
	public ModelAndView assistantdetails() {

		List<User> user = this.adminService.toViewUser();
		ModelAndView m = new ModelAndView();
		m.addObject("users", user);
		m.setViewName("assistantdetails");
		return m;
	}

	@GetMapping("/toadduser")
	public String toAddUser(Model m) {
		m.addAttribute("title", "Add");
		m.addAttribute("action", "adduser");
		return "addassistant";
	}

	@PostMapping("/adduser")
	public ModelAndView addUser(@ModelAttribute User user) {
		boolean id;
		ModelAndView m = new ModelAndView();
		id = this.adminService.toAddUser(user);
		if (id == false) {
			m.addObject("cl", "alert alert-danger ");
			m.addObject("msg", "Error Adding User");
			m.setViewName("addUser");
		} else {
			m.setViewName("redirect:/assistantdetails");
		}
		return m;
	}
	
	@GetMapping("/deleteuser/{uId}")
	public String deleteUser(@PathVariable("uId") int id) {
		this.adminService.toDeleteUser(id);
		return "redirect:/assistantdetails";
	}
	
	@GetMapping("/toupdateuser/{uId}")
	public String toUpdateUser(@PathVariable("uId") int id, Model m) {

		User u = this.adminService.toViewUserById(id);
		m.addAttribute("u", u);
		m.addAttribute("title", "Update");
		m.addAttribute("action", "updateuser");
		return "addassistant";
	}

	@PostMapping("/updateuser/{uId}")
	public String updateUser(@ModelAttribute User user) {
		boolean id = this.adminService.toEditUser(user);
		if (id == false) {
			return "error";
		} else {
			return "redirect:/assistantdetails";
		}
	}
}
