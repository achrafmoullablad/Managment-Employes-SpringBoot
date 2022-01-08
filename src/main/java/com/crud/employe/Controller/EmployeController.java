package com.crud.employe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.employe.Entity.Employe;
import com.crud.employe.Service.EmployeService;

@Controller
public class EmployeController {
	@Autowired
	private EmployeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Employe> list=service.list();
		model.addAttribute("listEmp", list);
        return "index";
	}
	@GetMapping("/new")
	public String add(Model model) {
	     model.addAttribute("employe", new Employe());
	     return "new";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("employe") Employe emp ) {
		service.save(emp);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("new");
        Employe emp = service.findById(id);
        mav.addObject("employe", emp);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    } 
}
