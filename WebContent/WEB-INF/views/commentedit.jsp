<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	        			<span class="subheading">Posted by ${blog.getAuthor() } on ${blog.getDate().getMonth()+1}/${blog.getDate().getDay()}/${blog.getDate().getYear()+1900}</span>
	    			</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-lg-8">
					<p>${blog.setContents(); blog.getContents() }</p>
				</div>
			</div>
		</div>
		<div class="container">
			<form:form action="./${blog.getId() }/postComment" method="post" modelAttribute="comment">
				<div class="input-group">
					<form:textarea cssClass="form-control" path="commentContents" placeholder="Comment..." />
				</div>
				<div class="input-group-prepend">
					<button class="btn btn-primary btn-block" type="submit">Submit</button>
				</div>
			</form:form>
		</div>
		<div class="container">
			<c:forEach items="${blogComments}" var="individualcomment">
				<c:choose>
					<c:when test="${individualcomment.getAuthor() == username}">
						<c:choose>
							<c:when test="${individualcomment.getId() == commentToEdit }">
								<form method="post" action="${pageContext.request.contextPath}/blog/${blog.getId()}/${individualcomment.getId()}/editComment">
									<textarea name="updatedComment" autofocus >${individualcomment.getContents() }</textarea>
									<button type="submit">Submit</button>
								</form>
							</c:when>
							<c:otherwise>
								<div class="row">
									<p>${individualcomment.getContents() }</p>
								</div>
								<div class="row">
									<form:form method="get" action="./${blog.getId()}/${individualcomment.getId()}/editComment">
										<input type="submit" value="Edit"/>
									</form:form>
									<form:form method="post" action="./${blog.getId() }/${individualcomment.getId()}/deleteComment">
										<input type="submit" value="Delete" />
									</form:form>
								</div>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<div class="row">
							<p>${individualcomment.getContents() }</p>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
</body>
</html>