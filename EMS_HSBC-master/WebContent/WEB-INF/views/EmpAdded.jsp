<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
html{
    background-color: rgb(79, 122, 73);
}
table{
    border-spacing: 0;
    border-collapse: collapse;
    width: 90%;
}
table th{
    text-align: left;
    background-color: rgb(36, 179, 55);
    color: #FFF;
    text-shadow: 1px 1px 0 rgba(0,0,0,.4);
}
table th,
table td{
    border: 1px solid rgb(55, 160, 69);
    padding: 10px;
}

table tbody tr:nth-child(odd) td{
    background-color: rgb(128, 202, 118);
}


/* table tbody tr:nth-child(even) td{
    background-color: rgb(42, 117, 52);
} */
  /* table {
    border: 3px solid black;
  }
  table td {
      border: 3px solid black;
    
  }</style>
</head>
<body>
<h1 align="center">Employee Management System</h1>
<div align="center">
                <table>
                    <tr>
                            <th><a href="EmpAddform.jsp">Employee Addition </a></th>
                            <th><a href="EmpSearchform.jsp">Employee Search </a></th>
                            <th><a href="EmpDeleteform.jsp">Employee Deletion </a></th>
                            <th><a href="ViewAllEmployeesform.jsp">ViewAllEmployees</a></th>
                    </tr>
                    <tr>
                        
                    </tr>
                </table>
                <div align="center">
<form action="Registration">
                <table>
                    <tr>
                <td>Employee Name:</td>
                <td><input type="text" name="EmployeeName" id =EmployeeName"  value = "" draggable="true" onblur="ValidateEmpName(this);"></td>
            </tr>
            <tr>
                <td>Nationality:</td>
		                <td><select id = "Nationality" name = "Nationality" value = "" draggable="true">
		                <option value="">Select Nationality</option>
							  <option value="Indian">Indian</option>
							  <option value="Saudi Arabian">Saudi Arabian</option>
							  <option value="Pakisthani">Pakisthani</option>
							  <option value="Japanese">Japanese</option>
							  <option value="American">American</option>
							  <option value="Others">Others</option>
							</select>
						</td>
            </tr>
            <tr>
                <td>National ID Number:</td>
                <td><input type="text" name="national_ID_NUM" id="national_ID_NUM" draggable="true">
                </td>
            </tr>
             <tr>
                <td>Role</td>
                <td><select name = "role" id="role" draggable="true" value = "">
		                <option value="">Select Role</option>
							  <option value="Developer">Software engineer</option>
							  <option value="Sr Soft Engineer">Sr Software Engineer</option>
							  <option value="Tech Lead">Tech Lead</option>
							  <option value="Manager">Manager</option>
							  <option value="Director">Director</option>
							  <option value="Network Eng">Network Engineer</option>
							  <option value="Infra Associate">Infra Structure Associate</option>
							  <option value="Hospitality ">Front Desk Executive</option>
							  
							</select>
				</td>
            </tr>
             <tr>
                <td>Department:</td>
                <td><select name = "department" id="department"  draggable="true" value = "" onchange="PopulateLineManager(this);">
		                <option value="">Select Department</option>
							  <option value="Technical">Technical Dept</option>
							  <option value="Infra">Infra Structure Dept </option>
							  <option value="Networking">Networking Dept</option>
							  <option value="Maintenance ">Maintenace Dept</option>
							</select>
				</td>
            </tr>
             <tr>
                <td>Line Manager:</td>
                <td><select name="lineManager"  id="lineManager" draggable="true"value = "">
		                	  <option value=""></option>
							  <option value="Technical">Technical Dept</option>
							  <option value="Infra">Infra Structure Dept </option>
							  <option value="Networking">Networking Dept</option>
							  <option value="Maintenance ">Maintenace Dept</option>
							</select>
				</td>
            </tr>
             <tr>
                <td>Email Address:</td>
                <td> <input type="text" name = "emailAddress" id="emailAddress" draggable="true"onblur="ValidateEmail(this);"> 
                </td>
            </tr> 
            <tr>
                <td>Mobile Number:</td>
                <td><input type="text" name ="mobileNo" id="mobileNo" draggable="true" onblur="ValidatePhone(this);"></td>
            </tr>
            <tr>
                <td colspan="4" align="center"><input type="submit" value="Add Employee"></td>
            </tr>
                </table>
            </form>
          
            <c:out value="${messagename}"></c:out>
            </div> 
</body>
</html>