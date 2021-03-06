<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="Description" content="Enter your description here"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="/css/profilestyle.css">
<title>MOOD</title>
<nav class="nav justify-content-center">
      <a class="nav-link" href="/dashboard">HOME</a>
      <a class="nav-link" href="/lookbook">LOOKBOOK</a>
      <a class="nav-link" href="/theblogs">THE BLOGS</a>
      <a class="nav-link" href="/offers">OFFERS</a>
      <a class="nav-link" href="/celebcorner">CELEB Corner</a>
      <a class="nav-link active" href="/user">Profile</a>
      <a class="nav-link" href="/logout">Logout</a>
</nav>
</head>
<body>
<!-- Left Panel  -->
<div class="container3">
    <div class="profile">
        <div class="profile-pic">
            <img src="http://placehold.">
            </div>
            <h4 class="user-name" c:out value="${user.firstName }">, MOOD</h4>
            <!-- <button class="btn" onclick="changeColor()"> MY MOOD </button> -->
        </div>
<div class="menu-box block">
    <ul class="menu-box-menu">
        <a class="menu-box-tab" href="/messages"><span></span>Messages<div class="menu-box-number">24</div></a>                            
            </li>
            <li>
                <a class="menu-box-tab" href="/likes"><span class="icon entypo-paper-plane scnd-font-color"></span>LIKES<div class="menu-box-number">3</div></a>                            
            </li>
            <li>
                <a class="menu-box-tab" href="/user/offers"><span class="icon entypo-calendar scnd-font-color"></span>OFFERS<div class="menu-box-number">5</div></a>                            
            </li>
            <li>
                <a class="menu-box-tab" href="/user/posts"><span class="icon entypo-cog scnd-font-color"></span>POSTS</a>
            </li>
        </ul>
    </div>
</div>
<div class="container3 middle">
   <h4>Settings</h4>
   <form id="edit" class="input-group" action="/user/update/{user.id}" modelAttribute="user" method="POST" style="font-size: 10px">
    <input type="email" class="input-field" placeholder="email" name="email" >  

    <select class="input-field" placeholder="gender" name="gender" id="gender">
        <option value="Female">Female</option>
        <option value="Male">Male</option>
        <option value="Other">Other</option>
        </select>

    <input type="date" class="input-field" name="birthdate">

    <input  type="text" class="input-field" placeholder="city" name="city">

    <select class="input-field" path="state">
        <c:forEach items="${states}" var="state">
            <option value="${state}"><c:out value="${state}"/></option>
        </c:forEach>
    </select>

          <input type="submit" class="submit-btn" value="Update"/>
      </form>
    </div> 
</div>
</body>
</html>
