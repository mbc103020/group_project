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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <title>MOOD</title>
</head>
<body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

<h1>MOOD</h1>
      
        <div class="marquee--inner">
            <div class="square"><h2>MOOD</h2></div>
                <div class="square red"><h2>BROADCAST</h2></div>
                <div class="square orange"><h2>LOOKBOOK</h2></div>
                <div class="square yellow"><h2>FABRICS</h2></div>
                <div class="square green"><h2>THE BLOGS</h2></div>
                <div class="square blue"><h2>RUNWAY</h2></div>
                <div class="square black">CELEB Corner</div>
                <div class="square pink"><h2>OFFERS</h2></div>

                <div class="square"><h2>MOOD</h2></div>
                <div class="square red"><h2>BROADCAST</h2></div>
                <div class="square brown"><h2>LOOKBOOK</h2></div>
                <div class="square yellow"><h2>FABRICS</h2></div>
                <div class="square green"><h2>THE BLOGS</h2></div>
              <div class="square blue"><h2>RUNWAY</h2></div>
              <div class="square black"><h2>CELEB Corner</h2></div>
              <div class="square pink"><h2>OFFERS</h2></div>

              <div class="square"><h2>MOOD</h2></div>
                <div class="square red"><h2>BROADCAST</h2></div>
                <div class="square orange"><h2>LOOKBOOK</h2></div>
                <div class="square yellow"><h2>FABRICS</h2></div>
                <div class="square green"><h2>THE BLOGS</h2></div>
                <div class="square blue"><h2>RUNWAY</h2></div>
                <div class="square black">CELEB Corner</div>
                <div class="square pink"><h2>OFFERS</h2></div>

                <div class="square"><h2>MOOD</h2></div>
      </div>
      
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

      
        <div class="marquee--inner">
        
        
              <div class="square blue"><h2>RUNWAY</h2></div>
              <div class="square black"><h2>CELEB Corner</h2></div>
              <div class="square pink"><h2>OFFERS</h2></div>
              <div class="square red"><h2>BROADCAST</h2></div>
              <div class="square brown"><h2>LOOKBOOK</h2></div>
              <div class="square yellow"><h2>FABRICS</h2></div>
              <div class="square green"><h2>THE BLOGS</h2></div>

              <div class="square"><h2>MOOD</h2></div>
              <div class="square red"><h2>BROADCAST</h2></div>
              <div class="square orange"><h2>LOOKBOOK</h2></div>
              <div class="square yellow"><h2>FABRICS</h2></div>
              <div class="square green"><h2>THE BLOGS</h2></div>
              <div class="square blue"><h2>RUNWAY</h2></div>
              <div class="square black">CELEB Corner</div>
              <div class="square pink"><h2>OFFERS</h2></div>

              <div class="square"><h2>MOOD</h2></div>
              <div class="square blue"><h2>RUNWAY</h2></div>
              <div class="square black"><h2>CELEB Corner</h2></div>
              <div class="square pink"><h2>OFFERS</h2></div>
              <div class="square red"><h2>BROADCAST</h2></div>
              <div class="square brown"><h2>LOOKBOOK</h2></div>
              <div class="square yellow"><h2>FABRICS</h2></div>
              <div class="square green"><h2>THE BLOGS</h2></div>


              <div class="square"><h2>MOOD</h2></div>
      </div>
      <div class="form-box">
        <div class="button-box">
            <div id="btn"></div>
          <button type="button" class="toggle-btn" onclick="login()">Login</button>
          <button type="button" class="toggle-btn" onclick="register()">Register</button> 
        </div>
        

  <form id ="login" class="input-group" action="/login" method="POST">
 
  <input type="email" class="input-field" placeholder="email" name="email" required>  
  <input type="password" class="input-field" placeholder="password" name="password" required>
  <p><c:out value="${errorMessage}" /></p> 
<input class="submit-btn" type="submit" value="Login">
  </form>

  <!-- <form:errors path="user.*"/> -->

  
      <form:form id="register" class="input-group" action="/registration" modelAttribute="user" method="POST" style="font-size: 10px">

              <form:label path="firstName"></form:label>
              <form:errors path="firstName"/>
              <form:input type="text" class="input-field" placeholder="First Name" path="firstName"/>


              <form:label path="lastName"></form:label>
              <form:errors path="lastName"/>
              <form:input type="text" class="input-field" placeholder="Last Name" path="lastName"/>

              <form:label path="email"></form:label>
              <form:errors path="email"/>
              <form:input type="email" class="input-field" placeholder="email" path="email"/>

              <form:label path="password"></form:label>
              <form:errors path="password"/>
              <form:password class="input-field" placeholder="Password" path="password"/>

              <form:label path="confirmPassword"></form:label>

              <form:errors path="confirmPassword"/>
              <form:password class="input-field" placeholder="Confirm Password" path="confirmPassword"/>
              <p><c:out value="${error}" /></p> 
          <input type="submit" class="submit-btn" value="Register"/>
      </form:form>
  </div>
    
      <script>
        var x = document.getElementById("login");
        var y = document.getElementById("register");
        var z = document.getElementById("btn");
        
        function register() {
        x.style.left = "-400px";
        y.style.left = "50px";
        z.style.left = "110px";
        }
        
        function login() {
        x.style.left = "50px";
        y.style.left = "450px";
        z.style.left = "0";
        }
        </script>
</body>
</html>