<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int result = 0;
	String res="";
	int num1 = Integer.parseInt((request.getParameter("num1")));
	int num2 = Integer.parseInt((request.getParameter("num2")));
	String option = request.getParameter("options");
	
	if (option.equals("add")) {
		result = (num1 + num2);
		res="The Sum of the two numbers is"+result;
	} else if (option.equals("sub")) {
		result = num1 - num2;
		res="The difference between the numbers is"+result;
	}else if (option.equals("mul")){
		result=num1*num2;
		res="The product of the numbers is"+result;
	}else if(option.equals("div")){
		result=num1/num2;
		res="The Divsion of Numbers is"+result;
	}else if(option.equals("fib")){
	 res="Fibonacci series is   "+num1;
	 //res=""+result;
	 int num=num1+1;
	 int temp=0;
	 do{
		 temp=num1+num;
		num1=num;
		num=temp;
		res+=","+num1;
	}while(temp<num2);

	}else if(option.equals("per")){
		result=((num1*100)/num2)/100;
		res="The percentage of numberis >>"+result;
	}
	%>
	<h1><%=res%></h1>
		
</body>
</html>