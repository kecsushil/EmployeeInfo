<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<form:form name="employeeForm" action="employeeInfo.do" commandName="employee">
<table>
	<tr> 
		<td>Employee ID</td>
        <td><form:input path='employeeID' name="id"/></td>
     </tr>
	<tr id="btnrow">
        <td colspan="2" class="employeeform">
            <input type="submit" value="Get Employee Info"/>
        </td>
    </tr>
</table>
</form:form>

</body>
</html>