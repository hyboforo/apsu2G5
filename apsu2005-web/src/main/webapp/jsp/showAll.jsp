<%-- 
    Document   : showAll
    Created on : Mar 18, 2018, 4:43:14 PM
    Author     : GEN-NTB-431
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APSU-2005</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td>First Name</td><td>Middle Name</td><td>Last Name</td><td>Phone</td><td>Email</td><td>Occupation</td><td>Course</td><td>Class</td><td>House</td><td>Country of Residence</td>
            </tr>
            <c:forEach items="${members}" var="s">
                <tr>
                    <td>${s.firstName}</td><td>${s.middleName}</td><td>${s.lastName}</td><td>${s.phone}</td><td>${s.email}</td><td>${s.occupation}</td><td>${s.program}</td><td>${s.courseClass}</td><td>${s.house}</td><td>${s.country}</td>
                </tr>
            </c:forEach>
        </table>
        <table>
            <tr><td><a href="Register"> Register</a></td></tr>
            <tr><td><a href="mail"> Send Mail </a></td></tr>
        </table>
    </body>
</html>
