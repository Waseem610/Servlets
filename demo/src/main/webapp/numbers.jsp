<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./operation.jsp" >
<input type="number" placeholder="Enter The first Number" name="num1">
<input type="number" placeholder="Enter The second Number" name="num2">
<h4>Options:</h3>
<select name="options" id="">
<option value="add">Addition</option>
<option value="sub">Subtraction</option>
<option value="mul">Multiplication</option>
<option value="div">Division</option>
<option value="fib">fibonacci</option>
<option value="per">Percentage</option>
</select>
<input type="submit" name="submit">

</form>

</body>
</html>