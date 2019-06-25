<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://cse.net.vn/form" %>
<%@ taglib prefix="t" uri="http://cse.net.vn/template" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:bg title="Timesheets Week">
	<jsp:attribute name="content">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th rowspan="2">Full Name</th>
					<th rowspan="2">Department</th>
					<th rowspan="2">Gender</th>
					<th rowspan="2">Date Of Birth</th>
					<!--td class="center">29/04/2019</td-->
					<!-- Begin Code Here -->
					<c:forEach var="date" items="${dates}">
						<td>${date}</td>
					</c:forEach>
					<!--  td class="center">30/04/2019</td>
					<td class="center">01/05/2019</td>
					<td class="center">02/05/2019</td>
					<td class="center">03/05/2019</td>
					<td class="center">04/05/2019</td>
					<td class="center">05/05/2019</td-->
					<!-- End Code Here -->
				</tr>
				<tr>
					<th>Monday</th>
					<th>Tuesday</th>
					<th>Wednesday</th>
					<th>Thursday</th>
					<th>Friday</th>
					<th>Saturday</th>
					<th>Sunday</th>
				</tr>
			</thead>
			<tbody id="sheet">
				<!-- Begin Code Here -->
				<c:forEach var="o" items="${list}">
				<tr data-id="${o.id}">
					<td>${o.fullName}</td>
					<td>${o.departmentName}</td>
					<td>${gender[o.gender]}</td>
					<td>${o.dateOfBirth}</td>
					
					<c:forEach var="i" begin="0" end="6">
						<td>
						<f:checkbox cssClass="chk" value="${dates[i]}"
								checked="${o.timesheet[i]}" />
								</td>
					</c:forEach>
				</tr>
			</c:forEach>
				<!--  tr data-id="1">
						<td>Vũ thị Thu Hà</td>
						<td>Giám đốc</td>
						<td>Female</td>
						<td class="right">25/01/1983</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr>
				
					<tr data-id="2">
						<td>Nguyễn Thái Hà</td>
						<td>P. Giám đốc</td>
						<td>Male</td>
						<td class="right">20/03/1990</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr>
				
					<tr data-id="3">
						<td>Trần Thị Hương</td>
						<td>Thư ký</td>
						<td>Female</td>
						<td class="right">04/05/2004</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr>
				
					<tr data-id="4">
						<td>Lê Thị Ngọc Minh</td>
						<td>Kế toán Trưởng</td>
						<td>Female</td>
						<td class="right">05/12/1979</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr>
				
					<tr data-id="5">
						<td>Nguyễn Thị Ngọc Ánh	</td>
						<td>Kế toán viên</td>
						<td>Female</td>
						<td class="right">23/04/2001</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr>
				
					<tr data-id="6">
						<td>Bùi Ngọc Tân</td>
						<td>Kế toán viên</td>
						<td>Male</td>
						<td class="right">04/05/2002</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=29/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=30/04/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk checked="checked" value=01/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=02/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=03/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=04/05/2019 >
							</td>
						
							<td class="center">
								<input type="checkbox" class=chk value=05/05/2019 >
							</td>
						
					</tr-->
				<!-- End code here -->
			</tbody>
		</table>
<script type="text/javascript">
$('chk').click(function(){
	var d = this.val();
	var id = this.parent('tr').attr('data-id');
	$.post('${pageContext.request.contextPath}/work/add.html', {'id': id, 'd': d}, function(x){
		alert(x);
	});
});
</script>
	</jsp:attribute>
</t:bg>
