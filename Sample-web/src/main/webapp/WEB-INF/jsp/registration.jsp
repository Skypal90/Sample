<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>


<form:form method="Post" action="registration.do" modelAttribute ="User">

<tr>
<td>first name</td>
<td><form:input path="firstName"></form:input><form:errors path="firstName" style="color:red"></form:errors></td>
</tr>
<tr>
<td>last name</td>
<td><form:input path="lastName"></form:input><form:errors path="lastName" style="color:green"></form:errors></td>
</tr>
<tr>
<td>email</td>
<td><form:input path="email"></form:input><form:errors path="email" style="color:red"></form:errors></td>
</tr>

<tr>
<td>password</td>
<td><form:input path="password"/><form:errors path="password" style="color:red"></form:errors></td>
</tr>
<tr>
<td>mobno</td>
<td><form:input path="mobNo"></form:input><form:errors path="mobNo" style="color:red"></form:errors></td>
</tr>


<tr>
<td><input type="submit" value="submit"/>
</tr>



</form:form>


</body>
</html>