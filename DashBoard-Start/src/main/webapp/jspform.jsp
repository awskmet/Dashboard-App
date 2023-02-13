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
Format for referencing objects or methods (more generally, things to be evaluated further) </br>
Implicit objects: param.name (pulls name paramater from paramater map) pageContext.request.contextPath, cookie.--cookiename--.value </br>
"$ { attribute NAME (that represents object/var/method) that is added to request by servlet in code (rto separate markup from code) }"</br>
"# { can do a set }"</br>

Expression Language: Reference Method:</br>
Doubled number of entered names:
${inputObjects.size() * 2}
${inputObjects.get(0).fieldName}
</form>
</body>
</html>