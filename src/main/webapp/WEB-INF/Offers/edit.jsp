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
<link rel="stylesheet" href="/css/style1.css">
<title>MOOD</title>
<nav class="nav justify-content-center">
      <a class="nav-link active" href="/dashboard">HOME</a>
      <a class="nav-link" href="/lookbook">LOOKBOOK</a>
      <a class="nav-link" href="/theblogs">THE BLOGS</a>
      <a class="nav-link" href="/offers">OFFERS</a>
      <a class="nav-link" href="/celebcorner">CELEB Corner</a>
      <a class="nav-link" href="/user">Profile</a>
      <!-- <a class="nav-link disabled" href="#">Disabled link</a> -->
</nav>
</head>
<body>
    <p>Post an Offer:</p>
    <form:form action="/offers/edit/{id}" method="post" modelAttribute="offer">
        <form:hidden value="${ user.id }" path="employer"/>
        <div class="form-group">
            <form:label path="title">Title</form:label>
            <form:errors path="title"></form:errors>
            <form:input class="form-control" path="title"></form:input>
        </div>
         <div class="form-group">
            <form:label path="city">City</form:label>
            <form:errors path="city"/>
            <form:input class="form-control" path="city" />
        </div>
        <div class="form-group">
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input class="form-control" path="state"/>
        </div>
        <div class="form-group">
            <form:label path="rate">Salary</form:label>
            <form:errors path="rate"/>
            <form:input class="form-control" path="rate"/>
        </div>
        <div class="form-group">
            <form:label path="company">Employer</form:label>
            <form:errors path="company"/>
            <form:input class="form-control" path="company"/>
        </div>
        <button>Update</button>
</form:form>
<a href="/offers/delete/${offer.id}">Delete</a>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>