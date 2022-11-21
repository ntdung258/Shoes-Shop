<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Left column -->
<div class="templatemo-flex-row">
	<div class="templatemo-sidebar">
		<header class="templatemo-site-header">
			<div class="square"></div>
			<h1>Product</h1>
		</header>
		<%@include file="/WEB-INF/views/layouts/admin/search.jsp"%>
		<%@include file="/WEB-INF/views/layouts/admin/nav-left.jsp"%>
	</div>
	<div class="templatemo-content col-1 light-gray-bg">
		<div class="templatemo-content-container">
			<div class="templatemo-content-widget no-padding">
				<div class="panel panel-default table-responsive">

					<table
						class="table table-bordered templatemo-user-table table-hover" style="border-bottom: 1px solid #ddd;">
						<thead>
							<tr>
								<td><a href="" class="white-text templatemo-sort-by">Id
										<span class="caret"></span>
								</a></td>
								<td><a href="" class="white-text templatemo-sort-by">Image
										<span class="caret"></span>
								</a></td>
								<td><a href="" class="white-text templatemo-sort-by">Name
										<span class="caret"></span>
								</a></td>
								<td><a href="" class="white-text templatemo-sort-by">Price<span
										class="caret"></span></a></td>
								<td><a href="" class="white-text templatemo-sort-by">Amount<span
										class="caret"></span></a></td>
								<td><a href="" class="white-text templatemo-sort-by">Color<span
										class="caret"></span></a></td>
								<td><a href="" class="white-text templatemo-sort-by">Type<span
										class="caret"></span></a></td>
								<td>Edit</td>
								<td>Delete</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listProduct }" var="product">
								<tr>
									<th>${product.id}</th>
									<td><div class="how-itemcart1">
											<img src="<c:url value="/assets/images/product/${product.linkImg }" />"
												style="with: 60px; height: 60px;" alt="IMG">
										</div></td>
									<td>${product.name}</td>
									<td><fmt:formatNumber currencySymbol=""
											value="${product.price}"></fmt:formatNumber> (VND)</td>
									<td>${product.amount}</td>
									<td>${product.color_Product.name}</td>
									<td>${product.type.name}</td>
									<td><a href="<c:url value="/admin/view-update-product/${product.id}" />" class="templatemo-edit-btn">Edit</a></td>
									<td><a href="<c:url value="/admin/delete-product/${product.id}" />" class="templatemo-link"
									onclick="return confirm('Sure?')">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<nav aria-label="Page navigation example" style="text-align: center;">
						<ul class="pagination">
							<li><a href="<c:url value="/admin/view-add-product" />">Add new product</a></li>
						</ul>
					</nav>
					
					
					<nav aria-label="Page navigation example" style="text-align: center;">
						<ul class="pagination">
							<c:forEach begin="1" end="${Math.ceil(count/5) }" var="i">
								<li class="page-item"><a class="page-link"
									href="<c:url value="/admin/view-product" />?page=${i}">${i }</a></li>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>