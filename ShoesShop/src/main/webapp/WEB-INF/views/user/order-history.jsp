<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<title>Order-History</title>
<!-- breadcrumb -->
	<div class="container" style="padding-top:100px;">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="<c:url value="/home" />" class="stext-109 cl8 hov-cl1 trans-04">
				Home
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<span class="stext-109 cl4">
				Order-History
			</span>
		</div>
	</div>
		

	<!-- Order-History -->
	
	<form class="bg0 p-t-75 p-b-85">
	
		<div class="container">
			<div class="row">
				<div class="m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
						
						
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">Bill Id</th>
									<th class="column-2">Total Price</th>
									<th class="column-2">Create Date</th>
									<th class="column-2">Recipient Name</th>
									<th class="column-2">Phone</th>
									<th class="column-2">Delivery Address</th>
									<th class="column-5">View Detail</th>
								</tr>
					
					<c:forEach items="${listBill }" var="bill">
								<tr class="table_row">
									<td class="column-1">${bill.id }</td>
									<td class="column-2"><fmt:formatNumber currencySymbol="" value="${bill.total_Price }"></fmt:formatNumber> (VND)</td>
									<td class="column-2">${bill.create_Date }</td>
									<td class="column-2">${bill.recipientName }</td>
									<td class="column-2">${bill.phone }</td>
									<td class="column-2">${bill.deliAddress }</td>
									<td class="column-5"><a href="<c:url value="/account/detail/${bill.id}" />">Detail</a></td>
								</tr>
					
					</c:forEach>
								
							</table>
					
						</div>

						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<a class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"
								href="#">
									Home
								</a>
							</div>
							
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<a class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"
								href="#">
									Clear History
								</a>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>