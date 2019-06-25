<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<form method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<p>
			<label>UserName</label>
			<input type="text" name="username">
		</p>
		<p>
			<label>PassWord</label>
			<input type="password" name="password">
		</p>
		<p>
			<label>Email</label>
			<input type="email" name="email">
		</p>
		<p>
			<button>Sign Up</button>
		</p>
	</form>
