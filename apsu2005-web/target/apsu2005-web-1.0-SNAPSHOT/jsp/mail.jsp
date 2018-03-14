<%-- 
    Document   : mail
    Created on : Mar 14, 2018, 1:11:20 PM
    Author     : GEN-NTB-431
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APSU 2005: Send Mail</title>
    </head>
    <body>
         <form:form id="mailForm" modelAttribute="mailer" action="mailProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="subject">Subject</form:label>
                        </td>
                        <td>
                        <form:input path="subject" name="subject" id="subject"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="message">Message</form:label>
                        </td>
                        <td>
                        <form:textarea path="message" name="message" id="message" rows="20" cols="50"/>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <form:button id="register" name="register">Send Mail</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
        </form:form>
</body>
</html>
