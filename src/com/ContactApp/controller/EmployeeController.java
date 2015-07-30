package com.ContactApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ContactApp.bean.EmployeeBean;
import com.ContactApp.bean.EmployeeImageUpload;
import com.ContactApp.bean.LoginBean;
import com.ContactApp.model.Employee;
import com.ContactApp.model.EmployeeImageUploadModel;
import com.ContactApp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/userImage" , method = RequestMethod.GET)
	public ModelAndView saveEmployeeImage(@ModelAttribute("command")EmployeeImageUpload empImage, BindingResult result){
		/* From here image processing and saving to data base */
		
		
		
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean,BindingResult result) {
		Employee employee = prepareModel(employeeBean);
		System.out.println("Employee class :"+employee.getPwd());
		System.out.println("EmployeeBean class :"+employeeBean.getPwd());
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/loginFrom" , method = RequestMethod.GET)
	public ModelAndView loginAndSession(@ModelAttribute("command") LoginBean loginbean , BindingResult result){
		String resultToSend = "";
		//System.out.println("This is Employee Controller 58line : "+loginbean.getEmployee_UserName());
		//System.out.println("This is Employee Controller 59line : " +loginbean.getEmployee_Userpwd());
		if(loginbean.getEmployee_UserName().equals("admin")&&loginbean.getEmployee_Userpwd().equals("admin")){
			resultToSend = "profile";
		}
		else{
			resultToSend = "error";
		}
		return new ModelAndView(resultToSend);
	}
	
	
	
	@RequestMapping(value = "/loginlink" , method = RequestMethod.GET)
	public ModelAndView loginLink(){
		return new ModelAndView("loginfrom");
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		//System.out.println("((((((((((((((Starts here)))))))))))))))))))))");
		System.out.println(employeeBean.getName());
		System.out.println(employeeBean.getPwd());
		System.out.println(employeeBean.getAge());
		System.out.println(employeeBean.getSalary());
		System.out.println(employee.getEmpAddress());
		
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setPwd(employeeBean.getPwd());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}
	
	private List<EmployeeBean> prepareListofBean(List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee employee : employees){
				bean = new EmployeeBean();
				bean.setName(employee.getEmpName());
				bean.setId(employee.getEmpId());
				bean.setPwd(employee.getPwd());
				bean.setAddress(employee.getEmpAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getEmpAge());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployeeBean prepareEmployeeBean(Employee employee){
		EmployeeBean bean = new EmployeeBean();
		bean.setAddress(employee.getEmpAddress());
		bean.setAge(employee.getEmpAge());
		bean.setName(employee.getEmpName());
		bean.setSalary(employee.getSalary());
		bean.setPwd(employee.getPwd());
		bean.setId(employee.getEmpId());
		return bean;
	}
	
}