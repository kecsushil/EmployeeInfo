package com.star.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.star.employee.VO.Employee;
import com.star.employee.VO.UserVo;
import com.star.employee.service.IEmployeeService;
import com.star.employee.validator.UserValidator;

@Controller
public class EmployeeController {

	
	private UserValidator userValidator;
	@Autowired
	private IEmployeeService  empService;
	
	
	public IEmployeeService getEmpService() {
		return empService;
	}



	public void setEmpService(IEmployeeService empService) {
		this.empService = empService;
	}



	@Autowired
	public EmployeeController(UserValidator userValidator){
		this.userValidator = userValidator;
	}
	
	
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView verifyUser() {
		System.out.println("Inside Controller ------> >>> login");
		ModelAndView mv = new ModelAndView();
		mv.addObject("userVo", new UserVo());
		
		mv.setViewName("login");
		
		return mv;
	}

	@RequestMapping(value = "/empInfo", method = RequestMethod.POST)
	public ModelAndView verifyLogin(@ModelAttribute("userVo") UserVo userVo,
            BindingResult result) {
		System.out.println("Inside Controller: ---------> >>> empInfo");
		ModelAndView homeMv = new ModelAndView();
		
		this.userValidator.validate(userVo, result);
		
		
		if (result.hasErrors()) {
			homeMv.setViewName("login");
		} else {
			homeMv.setViewName("home");
			homeMv.addObject("employee", new Employee());
		}

		return homeMv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ModelAndView confirmEmployeeSubmission(@ModelAttribute Employee employee) {
		System.out.println("Inside Controller: ---------> >>> employee");
		ModelAndView homeMv = new ModelAndView();
		boolean result = this.getEmpService().addEmployee(employee);
		homeMv.setViewName("result");
		if (result) { 
			
			homeMv.addObject("message", "Record submitted successfully!!");
		}else {
			
			homeMv.addObject("message", "Error occured while saving the record!!");
		}
		
		return homeMv;
		
		
	}
	
	
	@RequestMapping(value = "/employeeInfo/{id}", method = RequestMethod.GET)
	public ModelAndView getEmployeeInfo(@PathVariable Integer id) {
		System.out.println("Inside Controller: ---------> >>> getEmployeeID: " + id);
		ModelAndView homeMv = new ModelAndView();
		Employee employee = this.getEmpService().findById(id);
		homeMv.setViewName("employeeInfo");
		System.out.println("Returned!!");
		homeMv.addObject("employee", employee);
		

		return homeMv;
		
		
	}
	
	
	
	
	@RequestMapping(value = "/findemployee", method = RequestMethod.GET)
	public ModelAndView getEmployeeInfoPage() {
		System.out.println("Inside Controller: ---------> >>> getEmployeeID");
		ModelAndView homeMv = new ModelAndView();

		homeMv.setViewName("getEmpInfo");
		homeMv.addObject("employee",new Employee());
		return homeMv;
		
		
	}

}
