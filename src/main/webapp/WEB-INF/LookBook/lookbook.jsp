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
	<form:form id="addLook" action="/addLook" modelAttribute="look" enctype="mulitipart/form-data" method="POST">
		<form:label path="title"></form:label>     <!-- entype="multipart/form-data" tells browser this form may have a file upload, accept means only accept these types of files -->
		<form:input type="text" placeholder="Look Title" path="title"/>
		<div>
			<form:label path="imageName"></form:label>
			<form:input type="file" name="image" path="imageName" accept="image/png, image/jpeg" />
		</div>
		<input type="submit" value="Upload File" />

	</form:form>

<!--	<div>
		<c:forEach items="{files}" var="file">
		<ul>
			<li>
				<c:out value="${file}"/>
			</li>

		</ul>
		</c:forEach>
	</div>
	
		<div class="container">
			<c:forEach items="${looks} var="look">
				<div class="lookbook">

				</div>
				<c:out value="${look.title}"/>
			</c:forEach>
			
		</div>   -->
	


	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>