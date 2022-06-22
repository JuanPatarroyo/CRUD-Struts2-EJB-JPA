<%-- 
    Document   : person
    Created on : 9/06/2022, 8:31:29 p. m.
    Author     : jpatarroyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.title" /></title>
        <s:include value="header.jsp"></s:include>
        </head>
        <body>
            <div class="container">
                <div class="jumbotron">
                    <h1 class="display-4"><s:text name="form.title" /></h1>
                    <a class="btn btn-link" href="<s:url action="addPerson"/>"><s:text name="form.add" /></a>
                    <hr class="my-4">
                    <s:if test="people.size() > 0">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col"><s:text name="p.personId" /></th>
                                    <th scope="col"><s:text name="p.name" /></th>
                                    <th scope="col"><s:text name="p.surname" /></th>
                                    <th scope="col"><s:text name="p.secondSurname" /></th>
                                    <th scope="col"><s:text name="p.email" /></th>
                                    <th scope="col"><s:text name="form.edit" /></th>
                                    <th scope="col"><s:text name="form.delete" /></th>
                                </tr> 
                            </thead>
                            <tbody>
                                <s:iterator value="people">
                                    <tr>
                                        <td><s:property value="id" /></td>
                                        <td><s:property value="name" /></td>
                                        <td><s:property value="surname" /></td>
                                        <td><s:property value="lastSurname" /></td>
                                        <td><s:property value="email" /></td>
                                        <td>
                                            <s:url action="updatePerson" var="updateUrl">
                                                <s:param name="person.id" value="%{id}"></s:param>
                                            </s:url>
                                            <s:a href="%{updateUrl}" class="btn btn-outline-warning"><s:text name="form.edit" /></s:a>
                                            </td>
                                            <td>
                                            <s:url action="deletePerson" var="deleteUrl">
                                                <s:param name="person.id" value="%{id}"></s:param>
                                            </s:url>
                                            <s:a href="%{deleteUrl}" class="btn btn-outline-danger"><s:text name="form.delete" /></s:a>
                                            </td>
                                        </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </s:if>
                </div>
            </div>


        
    </body>
</html>