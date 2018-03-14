<%-- 
    Document   : register
    Created on : Mar 12, 2018, 8:20:46 PM
    Author     : GEN-NTB-431
--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>APSU 2005:Registration</title>
    </head>
    <body>
        
        <form:form id="regForm" modelAttribute="person" action="registerProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="firstName">First Name</form:label>
                        </td>
                        <td>
                        <form:input path="firstName" name="firstName" id="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="middleName">Middle Name</form:label>
                        </td>
                        <td>
                        <form:input path="middleName" name="middleName" id="middleName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="lastName">Last Name</form:label>
                        </td>
                        <td>
                        <form:input path="lastName" name="lastName" id="lastName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="email">Email</form:label>
                        </td>
                        <td>
                        <form:input path="email" name="email" id="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="phone">Phone Number</form:label>
                        </td>
                        <td>
                        <form:input path="phone" name="phone" id="phone" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="house">House</form:label>
                        </td>
                        <td>
                        <form:input path="house" name="house" id="house" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="courseClass">Class</form:label>
                        </td>
                        <td>
                        <form:input path="courseClass" name="courseClass" id="courseClass" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="program">Course</form:label>
                        </td>
                        <td>
                        <form:input path="program" name="program" id="program" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="occupation">Occupation</form:label>
                        </td>
                        <td>
                        <form:input path="occupation" name="occupation" id="occupation" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="country">Country of Residence</form:label>
                        </td>
                        <td>
                        <form:input path="country" name="country" id="country" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                </table>
        </form:form>
    </body>
</html>
