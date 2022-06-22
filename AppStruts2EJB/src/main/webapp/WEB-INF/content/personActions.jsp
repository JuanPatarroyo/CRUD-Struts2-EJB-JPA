<%-- 
    Document   : personActions
    Created on : 13/06/2022, 10:47:50 p. m.
    Author     : jpatarroyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.detail" /></title>
        <s:include value="header.jsp"></s:include>
    </head>
    <body>
        <div class="container">
            <h1 class="display-4"><s:text name="form.detail" /></h1>
            <a class="btn btn-link" href="<s:url action="list"/>"><s:text name="form.list" /></a>
            <hr class="my-4">
            <s:form action="savePerson">
                <s:hidden name="person.id" />
                <s:textfield class="form-control" name="person.name" key="p.name" />
                <s:textfield class="form-control" name="person.surname" key="p.surname" />
                <s:textfield class="form-control" name="person.lastSurname" key="p.secondSurname" />
                <s:textfield class="form-control" name="person.email" key="p.email" />
                <s:submit class="btn btn-success" action="savePerson" key="form.send"/>
            </s:form>
        </div>
    </body>
</html>