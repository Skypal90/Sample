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
<h1>Add Project</h1>
<form:form method="Post" action="PDetail.do" modelAttribute ="Project">
<table border="2px">
<tr>
<td>Project Name</td>
<td><form:input path="PName"/></td>
<td><form:errors path="PName"/></td>
</tr>
<tr>
<td>Start Time</td>
<td><form:input path="StDate"/></td>
<td><form:errors path="StDate"/></td>
</tr>
<tr>
<td>End Time</td>
<td><form:input path="EnDate"/></td>
<td><form:errors path="EnDate"/></td>
</tr>

<tr>
<td>Client Name</td>
<td><form:input path="cName"/></td>
<td><form:errors path="cName"/></td>
</tr>
<tr>
<td>
<td><input type="submit" value="Save"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form:form>

<table border="2px">
<tr><td>P_ID</td><td>P_Name</td><td>Start_Time</td><td>End_Time</td></tr>
 <c:forEach items="${list}" var="Project">
 <tr><td>${Project.id}</td>
 <td>${Project.pName}</td>
 <td>${Project.stDate}</td>
 <td>${Project.enDate}</td>
 <td>${Project.cName}</td>
 <td><a href="delete.do?id=${Project.id}">Delete</a></td>
 <td><a href="update.do?id=${Project.id}">Update</a></td> 
 </tr>
 </c:forEach>
</table>
</body>
</html>