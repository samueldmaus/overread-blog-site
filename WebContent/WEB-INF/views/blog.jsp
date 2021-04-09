<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
	<spring:url value="/resources/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/images/restaurant.jpg" var="homePhoto" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
	<%@ include file="navbar.jsp" %>
		<div class="jumbotron jumbotron-fluid" style="background-image:url(${homePhoto }); background-size: cover" >
			<div class="row">
				<div class="col-md-10 col-lg-8 mx-auto" style="color:#f5f5dc">
	    			<div class="site-heading">
	        			<h1>${blog.getTitle()}</h1>
	        			<span class="subheading">Posted by ${blog.getAuthor() } on ${blog.getDate().getMonth()+1}/${blog.getDate().getDate()}/${blog.getDate().getYear()+1900}</span>
	    			</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-lg-8">
					<p>${blog.setContents(); blog.getContents() }</p>
					<sec:authorize access="hasRole('ADMIN')">
						<form action="./${blog.getId() }/editBlog" method="get">
							<button type="submit" class="btn btn-secondary" style="margin:5px;">Edit Blog</button>
						</form>
						<form action="./${blog.getId() }/deleteBlog" method="post">
							<button type="submit" class="btn btn-danger" style="margin:5px;">Delete Blog</button>
						</form>
					</sec:authorize>
				</div>
			</div>
		</div>
		<br/>
		<div class="container">
			<div class="row">
				<div class="col">
					<form:form action="./${blog.getId() }/postComment" method="post" modelAttribute="comment">
						<div class="input-group">
							<form:textarea cssClass="form-control" path="commentContents" placeholder="Comment..." rows="5"/>
						</div>
						<div class="input-group-prepend">
							<button class="btn btn-primary btn-block" type="submit" style="margin-top:5px">Submit</button>
						</div>
					</form:form>
				</div>
				<div class="col"></div>
			</div>
		</div>
		<div class="container" style="padding:15px;">
			<c:forEach items="${blogComments}" var="individualcomment">
				<c:choose>
					<c:when test="${individualcomment.getAuthor() == username}">
						<div class="row" style="border-bottom: 3px solid black; margin:5px; padding:10px; display:block">
							<p style="display:block">${individualcomment.getContents() }</p>
							<p>-(You)</p>
							<form:form method="get" action="./${blog.getId()}/${individualcomment.getId()}/editComment">
								<input class="btn btn-secondary" type="submit" value="Edit" style="margin: 5px"/>
							</form:form>
							<form:form method="post" action="./${blog.getId() }/${individualcomment.getId()}/deleteComment">
								<input class="btn btn-danger" type="submit" value="Delete" />
							</form:form>
						</div>
					</c:when>
					<c:otherwise>
						<div class="row" style="border-bottom:3px solid black; margin:5px; padding:10px; display:block">
							<p>${individualcomment.getContents() }</p>
							<p>-${individualcomment.getAuthor() }</p>
							<sec:authorize access="hasRole('ADMIN')">
								<form:form method="post" action="./${blog.getId() }/${individualcomment.getId()}/deleteComment">
									<input class="btn btn-danger" type="submit" value="Delete" />
								</form:form>
							</sec:authorize>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
</body>
</html>