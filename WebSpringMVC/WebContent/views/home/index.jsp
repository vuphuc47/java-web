<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<select>
		<c:forEach var="p" items="${list}">
			<optgroup label="${p.name}">
				<c:forEach var="ch" items="${p.children}">
					<option value="${ch.id}">${ch.name}</option>
				</c:forEach>
			</optgroup>
		</c:forEach>
	</select>
	<div class="row">
		<div class="col-3">
			<ul>
				<c:forEach items="${group}" var="p">
					<li><a
						href="${pageContext.request.contextPath}/home/browse/${p.id}.html">${p.name}</a>
						<c:if test="${p.children != null}">
							<ul>
								<c:forEach var="q" items="${p.children}">
									<li><a
										href="${pageContext.request.contextPath}/home/browse/${q.id}.html">${q.name}</a>
									</li>
								</c:forEach>
							</ul>
						</c:if></li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-9">
			<div class="row">
				<c:forEach var="o" items="${product}">
					<div class="col-4">
						<h2>
							<a
								href="${pageContext.request.contextPath}/home/detail/${o.id}.html">${o.productName}</a>
						</h2>
						<a
							href="${pageContext.request.contextPath}/home/detail/${o.id}.html">
							<img class="img"
							src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
						</a>
						<p>
							<b>Price: </b> ${o.price}
						</p>
						<p>
							<b>Quantity: </b> ${o.quantity}
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
