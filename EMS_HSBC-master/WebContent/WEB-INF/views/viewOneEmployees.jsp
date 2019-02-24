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

<form action="EmpSearch">
                <table>
                    <tr>
                        <td>
                            <label for="EmployeeName" draggable="true">Enter Employee Number :</label>
                            <input type="text" name="EmployeeName" id="EmployeeName" draggable="true" ><br><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                                <center>
                            <input type="submit" value="Employee Search"/>
                                </center>
                        </td>
                    </tr>
                </table>
            </form>
            
            <br><br><br>              
<table>
  <c:forEach var="empobject" items="${empobject}">
		<tr><td>EmployeeNo:</td><td> ${empobject.getEmployeeNo()} </td></tr>
		<tr><td>EmployeeName:</td><td> ${empobject.getEmployeeName()} </td></tr>
		<tr><td>Nationality: </td><td>${empobject.getNationality()} </td></tr>
		<tr><td>national_ID_NUM:</td><td> ${empobject.getNational_ID_NUM()} </td></tr>
		<tr><td>role:</td><td> ${empobject.getRole()} </td></tr>
		<tr><td>department: </td><td>${empobject.getDepartment()} </td></tr>
		<tr><td>lineManager: </td><td>${empobject.getLineManager()}</td></tr>
		<tr><td>emailAddress:</td><td> ${empobject.getEmailAddress()} </td></tr>
		<tr><td>mobileNo:</td><td> ${empobject.getMobileNo()}</td></tr>
	</c:forEach>
	</table>
	</div>	
</body>
</html>