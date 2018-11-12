<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">

</head>
<body>
<h2>List all person in the database</h2>

	<c:if test="${!empty theList}">
	<table class="table table-striped">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>SURNAME</th>
		<th>AGE</th>
	</tr>
	 	<c:forEach var="p" items="${theList}">
	            <tr>
                    <td><c:out value="${p.id}"/></td>
                    <td><c:out value="${p.name}"/></td>
                    <td><c:out value="${p.surname}"/></td>
                    <td><c:out value="${p.age}"/></td>
                </tr>
		</c:forEach>
	</table>
	
	</c:if>

</body>
</html>