<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario</title>
    </head>
    <body>
        
    
        <form:form action="${/form}" method="post" modelAttribute="factura">
            <form:label path="description">Description: </form:label> <form:input type="text" path="description"/>
            <form:label path="cliente">Cliente: </form:label> <form:input type="text" path="cliente"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>