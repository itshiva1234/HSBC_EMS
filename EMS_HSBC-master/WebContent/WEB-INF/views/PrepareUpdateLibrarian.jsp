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
                            <th><a href="ViewAllEmployeesform.jsp">ViewAllEmployeesform </a></th>
                    </tr>
                    <tr>
                        
                    </tr>
                </table>
                <c:forEach var="empobject" items="${prepareEmployee}">
                <form action="UpdateEmployee">
                <table>
                    <tr>
                		
                			<td><label for="Nationality" draggable="true">EmployeeName:</label></td>  
                            <td><input type="text" value="${empobject.getEmployeeName()}" name="EmployeeName" id="EmployeeName" draggable="true"></td>
                 </tr>
                  <tr>
                      		<td><label for="Nationality" draggable="true">Nationality:</label>  </td>
                           <td> <input type="text" value="${empobject.getNationality()}" name="Nationality" id="Nationality" draggable="true"></td>
                       </tr>
                        <tr>
                            <td><label for="national_ID_NUM" draggable="true">National ID NUM:</label></td>
                            <td><input type="text" value="${empobject.getNational_ID_NUM()}" name="national_ID_NUM" id="national_ID_NUM" draggable="true"></td>
                         </tr>
                         <tr>
                            <td><label for="role" draggable="true">role:</label></td>
                            <td><input type="text" value="${empobject.getRole()}" name="role" id="role" draggable="true"></td>
                           </tr>
                            <tr> 
                            <td><label for="department" draggable="true">department:</label></td>
                            <td><input type="text" value="${empobject.getDepartment()}" name="department" id="department" draggable="true"></td>
                            </tr>
                            <tr>
                            <td><label for="lineManager" draggable="true">lineManager:</label></td>
                            <td><input type="text" value="${empobject.getLineManager()}" name="lineManager" id="lineManager" draggable="true"></td>
                            </tr>
                            <tr>
                            <td><label for="emailAddress" draggable="true">emailAddress:</label></td>
                           <td> <input type="text" value="${empobject.getEmailAddress()}" name="emailAddress" id="emailAddress" draggable="true"></td>
                            </tr>
                            <tr>
                            <td><label for="mobileNo" draggable="true">mobileNo:</label></td>
                            <td><input type="text" value="${empobject.getMobileNo()}" name="mobileNo" id="mobileNo" draggable="true"></td>
                 			</tr>
                 			<tr>
                    		<td><label for="EmployeeNo" draggable="true"></label></td>
                            <td><input type="hidden" value="${empobject.getEmployeeNo()}" name="EmployeeNo" id="EmployeeNo" draggable="true" onblur="validateEmpName();"></td>
                     		</tr>
                     		<tr>
                    <td> <input type="submit" value="Update Employee"></td>
                    </tr>
                </table>
  
            </form>
             </c:forEach>
  </div>       
</body>
</html>