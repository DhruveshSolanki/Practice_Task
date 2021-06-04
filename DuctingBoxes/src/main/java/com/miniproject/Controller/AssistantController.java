package com.miniproject.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.miniproject.Model.Duct;
import com.miniproject.Model.Project;
import com.miniproject.Service.AssistantService;

@Controller
public class AssistantController {

	@Autowired
	private AssistantService assistantService;

	@GetMapping("/assistanthome")
	public ModelAndView assistantHome() {

		List<Duct> ducts = this.assistantService.toViewDuct();
		ModelAndView m = new ModelAndView();
		m.addObject("duct", ducts);
		m.setViewName("assistant");
		return m;
	}
	
	@GetMapping("/toaddduct")
	public String toAddDuct(Model m) {
		m.addAttribute("title", "Add");
		m.addAttribute("action","addduct");
		return "addduct";
	}
	
	@PostMapping("/addduct")
	public ModelAndView addDuct(@ModelAttribute Duct duct) {
		int id;
		ModelAndView m = new ModelAndView();
		id = this.assistantService.toAddDuct(duct);
		if (id==0) {
			m.addObject("cl", "alert alert-danger ");
			m.addObject("msg", "Error Adding Duct");
			m.setViewName("addduct");
		}
		else {
			m.setViewName("redirect:/assistanthome");
		}
		return m;
	}
	
	@GetMapping("/deleteduct/{dId}")
	public String deleteDuct(@PathVariable("dId") int id ) {
		this.assistantService.toDeleteDuct(id);
		return "redirect:/assistanthome";
	}
	
	@GetMapping("/toupdateduct/{dId}")
	public String toUpdateDuct(@PathVariable("dId") int id, Model m ) {
		
		Duct d = this.assistantService.toViewDuctById(id);
		m.addAttribute("d",d);
		m.addAttribute("title", "Update");
		m.addAttribute("action","updateduct");
		return "addduct";
	}
	
	@PostMapping("/updateduct/{dId}")
	public String updateDuct(@ModelAttribute Duct duct) {
		int id= this.assistantService.toEditDuct(duct);
		if (id==0) {
			return "error";
		} else {
			return "redirect:/assistanthome";
		}
	}
}
