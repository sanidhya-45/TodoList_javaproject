<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="Updatelist" method="get">
		<div><label>Enter the id of the task</label></div>
		Task Id : <input type="text" name="id"/><br>
		<div><label>Enter all the details you want to update</label></div>
		Task Name : <input type="text" name="taskname" /><br>
		Time : <input type="text" name="time" /><br>
		Priority : <input type="text" name="priority" /><br>
		<input type="submit"/><br>
	</form>
</body>
</html>