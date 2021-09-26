<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MOOD</title>
</head>
<body>

  <div>
    <h1>Login</h1>
    <p><c:out value="${errorMessage}" /></p> 
    <form action="/login" method="POST">
   
    <h4>Email:<input type="email" name="email"></h4>
        <h4>Password:<input type="password" name="password"></h4>
        <input class="btn" type="submit" value="Login">
    </form>
  </div>



  <div>
    <h1>Register</h1>
    <form:errors path="user.*"/>
    <p><c:out value="${error}" /></p> 
        <form:form  action="/registration" modelAttribute="user" method="POST">

            <h4>
                <form:label path="firstname">First Name:</form:label>
                <form:input type="text" path="firstname"/>
            </h4>

            <h4>
                <form:label path="lastname">Last Name:</form:label>
                <form:input type="text" path="lastname"/>
            </h4>
        
            <h4>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
            </h4>
    
            <h4>
                <form:label path="password">Password:</form:label>
                <!-- <form:errors path="password"/> -->
                <form:password path="password"/>
            </h4>
            <h4>
                <form:label path="confirmPassword">Confirm Password:</form:label>
                <!-- <form:errors path="confirmPassword"/> -->
                <form:password path="confirmPassword"/>
            </h4>
            <input type="submit" value="Register"/>
        </form:form>

    </div>
      </div>  
</body>
</html>