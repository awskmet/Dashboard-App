<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
I'll stay
<form action="jspform" method=post>
<input type="text" name="inputname" title="i also have a filter on me"/>
<input type = "submit" value="Input Value"/>
${inputname}
</form>
</body>
</html>