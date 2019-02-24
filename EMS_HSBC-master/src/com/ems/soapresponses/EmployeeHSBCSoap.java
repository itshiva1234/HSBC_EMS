package com.ems.soapresponses;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.Query;

import org.hibernate.Session;

import com.ems.ORM_Hibernate.ConnectionClass;
import com.ems.domain.EmployeeHSBC;

import java.util.List;

@WebService
public class EmployeeHSBCSoap {

	
	@WebMethod()
	@WebResult(name="status")
	public List<EmployeeHSBC> getAllEmployees(){
		Session  hibernateSession=ConnectionClass.getsession();
		hibernateSession.beginTransaction();
		org.hibernate.Query query=hibernateSession.createQuery("from EmployeeHSBC");
		List<EmployeeHSBC> list=query.list();
		
		return list;
		
	}
	
	@WebMethod
	@WebResult(name="status")
	public List<EmployeeHSBC> ViewParticularEmployee(@WebParam(name="EmployeeNo")int EmployeeNo)  {
	Session hibernateSession=ConnectionClass.getsession();
	hibernateSession.beginTransaction();
	org.hibernate.Query query=hibernateSession.createQuery("from EmployeeHSBC where EmployeeNo='"+EmployeeNo+"'");
	List<EmployeeHSBC> list=query.list();
	
	return list;
	}
	
	@WebMethod
	@WebResult(name="status")
	public String DeleteParticularEmployee(@WebParam(name="EmployeeNo")int EmployeeNo)  {
	Session hibernateSession=ConnectionClass.getsession();
	hibernateSession.beginTransaction();
	EmployeeHSBC del_emp= new EmployeeHSBC(EmployeeNo);
	String ename=del_emp.getEmployeeName();
	hibernateSession.delete(del_emp);
	hibernateSession.getTransaction().commit();
	hibernateSession.close();	
	
	return "--Employee Deleted Successfully";
	}
	
	@WebResult(name="status")
	public String AddNewEmployee(@WebParam(name="EmployeeName")String EmployeeName,
							 @WebParam(name="Nationality")String Nationality,
							 @WebParam(name="Author")int national_ID_NUM,
							 @WebParam(name="role")String role,
							 @WebParam(name="department")String department,
							 @WebParam(name="lineManager")String lineManager,
							 @WebParam(name="emailAddress")String emailAddress,
							 @WebParam(name="mobileNo")String mobileNo)
	{
		EmployeeHSBC newemp = new EmployeeHSBC(EmployeeName, Nationality, national_ID_NUM, role, department, lineManager, emailAddress, mobileNo);
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		session.save(newemp);
		session.getTransaction().commit();
		session.close();
		
		return "success";
		
		
	}
}
