package com.ems.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.ORM_Hibernate.ConnectionClass;
import com.ems.domain.EmployeeHSBC;

@Controller
public class WelcomeController {
	
	
	@RequestMapping("/")
	public String doWelcome(Model model) {
	try {
				return "EMSHomePage";
	}
	catch(Exception e)
	{
		return "404";
	}
		
	}
	
	/*Method to add an Employee*/
	@RequestMapping(value="/Registration" ,method=RequestMethod.GET)
	public String addEmployee(Model model,@RequestParam("EmployeeName") String EmployeeName,
										  @RequestParam("Nationality") String Nationality,
										  @RequestParam("national_ID_NUM") int national_ID_NUM,
										  @RequestParam("role") String role,
										  @RequestParam("department") String department,
										  @RequestParam("lineManager") String lineManager,
										  @RequestParam("emailAddress") String emailAddress,
										  @RequestParam("mobileNo") String mobileNo)
	{
		
		EmployeeHSBC new_employee= new EmployeeHSBC(EmployeeName, Nationality, national_ID_NUM, role, department, lineManager, emailAddress, mobileNo);
		Session  hibernateSession=ConnectionClass.getsession();
		hibernateSession.beginTransaction();
		hibernateSession.save(new_employee);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		model.addAttribute("messagename","employee added");
		return "EmpAdded";
	}
	
	/*Method to Delete an Employee*/
	@RequestMapping("/EMPDelete")
	public String DeleteEmployee(Model model,@RequestParam("EmployeeNo") int EmployeeNo) {
		Session hibernateSession=ConnectionClass.getsession();
		hibernateSession.beginTransaction();
		EmployeeHSBC del_emp= new EmployeeHSBC(EmployeeNo);
		model.addAttribute("empname",del_emp.getEmployeeName());
		hibernateSession.delete(del_emp);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();	
		
		return "EmpDeleted";
	}
	
	@RequestMapping(value="/ViewAllEmployees",method=RequestMethod.GET)
	public String viewAllEmployees(Model model) {
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		org.hibernate.Query query=session.createQuery("from EmployeeHSBC");
		List<EmployeeHSBC> emplist=query.list();
		model.addAttribute("empobject",emplist);
		return "ViewAllEmployees";
	}
	
	@RequestMapping(value="/EmpSearch",method=RequestMethod.GET)
	public String SearchEmployee(Model model,@RequestParam("EmployeeName") int EmployeeNo)
	{
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		org.hibernate.Query query=session.createQuery("from EmployeeHSBC where EmployeeNo='"+EmployeeNo+"'");
		model.addAttribute("empobject", query.list());
		return "viewOneEmployees";
	}
	
	@RequestMapping(value="/PrepareUpdateLibrarian",method=RequestMethod.GET)
	public String PrepareLibrarianUpdatePage(@RequestParam("EmployeeNo") int EmployeeNo,Model model) {
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		org.hibernate.Query query=session.createQuery("from EmployeeHSBC where EmployeeNo='"+EmployeeNo+"'");
		model.addAttribute("prepareEmployee",query.list());
		return "PrepareUpdateLibrarian";
	}
	
	@RequestMapping(value="/UpdateEmployee" ,method=RequestMethod.GET)
	public String UpdateEmployee(Model model,@RequestParam("EmployeeName") String EmployeeName,
										  @RequestParam("Nationality") String Nationality,
										  @RequestParam("national_ID_NUM") int national_ID_NUM,
										  @RequestParam("role") String role,
										  @RequestParam("department") String department,
										  @RequestParam("lineManager") String lineManager,
										  @RequestParam("emailAddress") String emailAddress,
										  @RequestParam("mobileNo") String mobileNo,
										  @RequestParam("EmployeeNo") int EmployeeNo)
	{
		System.out.println("code came to final update");
		
		EmployeeHSBC new_employee= new EmployeeHSBC(EmployeeName, Nationality, national_ID_NUM, role, department, lineManager, emailAddress, mobileNo);
		Session  hibernateSession=ConnectionClass.getsession();
		hibernateSession.beginTransaction();
		EmployeeHSBC updateEmlpoyee=(EmployeeHSBC)hibernateSession.get(EmployeeHSBC.class,EmployeeNo);
		updateEmlpoyee.setEmployeeName(EmployeeName);
		updateEmlpoyee.setNationality(Nationality);
		updateEmlpoyee.setNational_ID_NUM(national_ID_NUM);
		updateEmlpoyee.setRole(role);
		updateEmlpoyee.setDepartment(department);
		updateEmlpoyee.setLineManager(lineManager);
		updateEmlpoyee.setEmailAddress(emailAddress);
		updateEmlpoyee.setMobileNo(mobileNo);
		hibernateSession.update(updateEmlpoyee);
		
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		model.addAttribute("messagename","Employee Updated");
		return "EMSHomePage";
	}
	
	@RequestMapping(value="/*",method=RequestMethod.GET)
	public String FaultHandlingMethod1() {
		return "404";
	}
	@RequestMapping(value="*.jsp",method=RequestMethod.GET)
	public String FaultHandlingMethod2() {
		return "404";
	}
	@RequestMapping(value="/*/*",method=RequestMethod.GET)
	public String FaultHandlingMethod3() {
		return "404";
	}
	
}
