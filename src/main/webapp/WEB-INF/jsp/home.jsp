<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
<p>We are inside home!!</p>

<form:form name="employeeForm" action="employee.do" commandName="employee">
      <table id="employee">
          <tr id='empinfo'>
          <td><table id='innertable'>
          <tr> <td>First Name:</td>
           <td><form:input path='firstname' /></td>
           </tr><tr><td>Last Name:</td>
           <td><form:input path='lastname' /></td>
           </tr><tr><td>Zip Code:</td> <td>
           <form:input path='zipcode' id="zipcodeid" onkeyup="getZipCode()" required="true"/></td> 
           </tr> <tr> <td>Street#:</td>
           <td><form:input path='street' id="street"/></td>
           </tr> 
           <tr><td>City:</td>
           <td><form:input path='city'  id="city"/>
           </td>
           </tr>
           <tr><td>State:</td>
           <td><form:input path='state' id="state"/>
           </td>
           </tr>
           <tr><td>Country:</td>
           <td><form:input path='country' id="country"/>
           </td>
           </tr>
           </table>
           </td>
           </tr>
           <tr/>
           <tr id="btnrow">
              <td colspan="2" class="employeeform">
                  <input type="submit" value="Employee Form"/>
              </td>
          </tr>
      </table>
  </form:form> 
  
  
<script>




 
 function getZipCode() {
	 
	 var ZIPCODE = $('#zipcodeid').val();
	
	if ($('#zipcodeid').val().length == 5 && $.isNumeric(ZIPCODE)) {
		$.getJSON("http://ZiptasticAPI.com/" + ZIPCODE).success(function (data) { $('#state').val(data.state);$('#country').val(data.country); $('#city').val(data.city);}).error(function () {if($('#state').val()) {

			alert("Please enter a valid ZIPCODE. Could not get address using Ziptastic API.");
			
			}});
	 
	 }
	else {
		$('#state').val('');
		$('#country').val('');
		$('#city').val('')
	}
	
	  
	 
 }

 
</script>

</body>
</html>