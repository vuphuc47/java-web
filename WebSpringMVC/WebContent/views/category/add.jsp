<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://WebSpringMVC.com/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<form:group name="asdeasd" items="${group}"/>

	<f:form modelAttribute="o" method="post">
		<p>
			<lable>Parent</lable>
			<f:select path="parent">
				<option value="">--Select Parent--</option>
				<f:options itemValue="id" itemLabel="Name" items="${list}" />
			</f:select>
		</p>
		<p>
			<label>Name</label>
			<f:input path="name" />
		</p>
		<p>
			<button>Save</button>
		</p>
	</f:form>

	<form method="post">
		<p>
			<lable>Parent</lable>
			<select name="parent">
				<option value="">Select Parent</option>
				<c:forEach var="p" items="${list}">
					<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>Name</label> <input type="test" name="name">
		</p>
		<p>
			<button>Save</button>
		</p>
	</form>
