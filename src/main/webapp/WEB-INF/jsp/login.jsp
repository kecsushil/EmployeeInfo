<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>

<head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Login Page</title>
</head>

<body>

<c:url value="/j_spring_security_check" var="loginUrl" />

<form:form method="POST" action="${loginUrl}" commandName="userVo">
      
      <c:if test="${param.error != null}">        
		<p>
			Invalid username and password.
		</p>
	</c:if>
      
      <table>
          <tr>
              <td>User Name:</td>
              <td><form:input path="username" placeholder="username"/></td>
              <td><form:errors path="username" cssClass="error" /></td>
          </tr>
          <tr>
              <td>Password:</td>
              <td><form:password path="password" placeholder="password"/></td>
              <td><form:errors path="password"  cssClass="error" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="login" />
              </td>
          </tr>
      </table>
      <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
  </form:form> 



</body>
</html>



  
  
 
  
  
 