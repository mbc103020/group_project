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
<link rel="stylesheet" href="/css/style2.css">

<title>MOOD</title>
<nav class="nav justify-content-center">
      <a class="nav-link active" href="/dashboard">HOME</a>
      <a class="nav-link" href="/lookbook">LOOKBOOK</a>
      <a class="nav-link" href="/blogs">THE BLOGS</a>
      <a class="nav-link" href="/offers">OFFERS</a>
      <a class="nav-link" href="/celebcorner">CELEB Corner</a>
      <a class="nav-link" href="/user">Profile</a>
      <a class="nav-link" href="/logout">Logout</a>

      <!-- <a class="nav-link disabled" href="#">Disabled link</a> -->
</nav>
</head>
<body>
    <div class ="section">
        <div class="part">
<!--    <h2>QUICK LINKS</h2>
    <a href="/shops">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        SHOPS
    </a>
    <a href="https://www.vogue.com">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        VOGUE
    </a>
    <a href="https://99designs.com/blog/tips/how-color-impacts-emotions-and-behaviors/">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        MOODS
    </a>

        </div>
    </div> -->
    <h3>Fashion Blog</h3>
    <p>Submit a blog post</p>
    <div id="blogForm">
       <form:form id="newBlogPost" action="/newBlogPost" modelAttribute="post" method="POST">
        <form:label path="title"></form:label>
        <form:input type="text" placeholder="Title" path="title"/>

        <form:label path="content"></form:label>
        <form:textarea path="content" row="20" col="40"></form:textarea>

        <input type="submit" class="submit" value="Submit Post"/>

        </form:form>
    </div>
    
    <div class="blogposts">
    	<c:forEach items="${posts}" var="post">
    		<div class="post">
                <h2 class="post-title">
                    <a class="like" href="/likePost/${post.id}">Like</a>
                    <c:out value="${post.title}"/> 
         <!--         <c:if test = "${post.user == loggedInUser}"> 
                            <p><a href="/updatePost/${post.id}"></a>
                            <a href="/deletePost/${post.id}"><button>Delete Post</button></a></p>
                     </c:if> -->
                </h2>
                <div class="post-content">
                    <p><c:out value="${post.content}"/></p>
                    <p class="post-author">Author: <c:out value="${post.user.firstName}"/> <c:out value="${post.user.lastName}"/></p>
                </div>
                    <p><a href="/editPost/${post.id}"><button>Update Post</button></a><a href="/deletePost/${post.id}"><button>Delete Post</button></a> </p> 
                
    		</div>
    	</c:forEach>
    </div> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>