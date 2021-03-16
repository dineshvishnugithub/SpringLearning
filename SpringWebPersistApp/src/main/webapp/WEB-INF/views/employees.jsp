<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Form</title>
</head>
<body>
   <div align="center">
     <springform:form action="saveEmployeeDet" method="POST" modelAttribute="employeesdet">
      <table>
         <tr>
            <td colspan="2" align="center"><h2>Employees registration</h2></td>
         </tr>
         <tr>
           <td>Employee Id:</td>
           <td><springform:input path="employeeId" /></td>
         </tr>
         <tr>
           <td>First Name:</td>
           <td><springform:input path="firstName" /></td>
         </tr>
         <tr>
           <td>Last Name:</td>
           <td><springform:input path="lastName" /></td>
         </tr>
         <tr>
           <td>Email:</td>
           <td><springform:input path="email" /></td>
         </tr>
         <tr>
           <td>Phone No:</td>
           <td><springform:input path="phoneNumber" /></td>
         </tr>
         <tr>
           <td>Hire date:</td>
           <jsp:useBean id="date" class="java.util.Date"/>
           <td><springform:input type="date" path="hireDate" /></td>
         </tr>
         <tr>
           <td>Job Id:</td>
           <td><springform:input path="jobID" /></td>
         </tr>
         <tr>
           <td>Salary:</td>
           <td><springform:input path="salary" /></td>
         </tr>
         <tr>
           <td>Commission Pct:</td>
           <td><springform:input path="commissionPct" /></td>
         </tr>
         <tr>
           <td>Manager Id:</td>
           <td><springform:input path="managerId" /></td>
         </tr>
         <tr>
           <td>Department Id:</td>
           <td><springform:input path="departmentId" /></td>
         </tr>
         <tr>
           <td colspan="2" align="center"><input value="Register" type="submit"/></td>
         </tr>
      </table>
     </springform:form>
   </div>
</body>
</html>