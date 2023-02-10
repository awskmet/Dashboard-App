<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

I'll stay
</br>

<form action="jspform" method=post>
<input type="text" name="inputname"/>
<input type="text" name="inputnametwo"/>
<input type = "submit" value="Input Value"/></br>

I'll show up as individually added Strings from input box, to JSPServlet post, to auto-created servlet that returns html with added vars:</br> 

${inputname}</br>
${inputnametwo}</br>

I'll show up as looping thorugh list of object from input box, to JSPServlet  post (creates object)-> to auto-created servlet that returns html with added vars:</br> 
<c:forEach items="${inputObjects}" var="anyName">
<%--don't need c out could just do $ { } without quotes, out essentially just escapes output good for security --%>
<c:out value = "${anyName.fieldName}"/> 
(ref object needs getter and setter to use like this)
</br>
</c:forEach>

</br>

INFO</br> 
--------<br/>
JSTL library: </br>
Include other tags for doing things like for each or calling a method</br>
"<-%-@ taglib prefix = --In Quotes-- uri = -- In Quotes --%->"</br>
</br>
Expression Language:</br>
Format for referencing things in your code (more generally, things to be evaluated further) </br>
"$ { Variable/attribute NAME that is added to request by servlet in code (request attribute) }"</br>
"# { can do a set }"</br>
</form>
</body>
</html>