<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <title>MOOD</title>
</head>
<body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <div class="container">
      <div class="section">
    <h1>Login</h1>
    <p><c:out value="${errorMessage}" /></p> 
    <form action="/login" method="POST">
   
    <h4>Email:<input type="email" name="email"></h4>
        <h4>Password:<input type="password" name="password"></h4>
        <input class="btn" type="submit" value="Login">
    </form>
  </div>




  <div class="section">
    <h1>Register</h1>
    <form:errors path="user.*"/>
    <p><c:out value="${error}" /></p> 
        <form:form  action="/registration" modelAttribute="user" method="POST">

            <h4>
                <form:label path="firstName">First Name:</form:label>
                <form:input type="text" path="firstName"/>
            </h4>

            <h4>
                <form:label path="lastName">Last Name:</form:label>
                <form:input type="text" path="lastName"/>
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