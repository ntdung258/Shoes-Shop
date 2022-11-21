<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Shopping-Cart</title>
<!-- breadcrumb -->
	<div class="container" style="padding-top:100px;">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="<c:url value="/home" />" class="stext-109 cl8 hov-cl1 trans-04">
				Home
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<span class="stext-109 cl4">
				Shoping Cart
			</span>
		</div>
	</div>
		

	<!-- Shoping Cart -->
	
	<form class="bg0 p-t-75 p-b-85">
	
		<div class="container">
			<div class="row">
				<div class="m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
						
						
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-2">Product</th>
									<th class="column-2">Name</th>
									<th class="column-2">Price</th>
									<th class="column-2">Quantity</th>
									<th class="column-2">Total</th>
								</tr>
					
					<c:forEach items="${cart_Item }" var="item">
								<tr class="table_row table-bordered" style="text-align: center;">
									<td class="column-2">
										<div class="how-itemcart1">
											<img src="<c:url value="/assets/images/product/${item.link }" />" alt="IMG">
										</div>
									</td>
									<td class="column-2">${item.name }</td>
									<td class="column-2"><fmt:formatNumber currencySymbol="" value="${item.price }"></fmt:formatNumber> (VND)</td>
									<td class="column-2">
										<div class="wrap-num-product flex-w m-l-auto m-r-0" style="float:left;">
																						
											<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m changeAmount" data-id="${item.id_Product }" >
												<i class="fs-16 zmdi zmdi-minus"></i>
											</div>
											

											<input class="mtext-104 cl3 txt-center num-product" type="number" name="amount" value="${item.amount }"
											 id="edit-Amount-${item.id_Product }" data-id="${item.id_Product }">

											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m changeAmount"  data-id="${item.id_Product }">
												<i class="fs-16 zmdi zmdi-plus"></i>
											</div>
											
											
										</div>
									</td>
									<td class="column-2"><fmt:formatNumber currencySymbol="" value="${item.price * item.amount}"></fmt:formatNumber> (VND)</td>
	
					</c:forEach>
								
							</table>
					
						</div>

						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<a class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"
								href="<c:url value="" />">
									Home
								</a>
							</div>
							
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<a class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"
								href="<c:url value="/shopping-cart/clear" />">
									Clear Cart
								</a>
							</div>
							
						</div>
					</div>
				</div>

				
			</div>
			
			<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
								<span class="mtext-101 cl2">
									Total:
								</span>
							</div>

							<div class="size-209 p-t-1">
								<span class="mtext-110 cl2">
									<fmt:formatNumber currencySymbol="" value="${totalPrice}"></fmt:formatNumber> (VND)
								</span>
							</div>
						</div>

						<a class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
						href="<c:url value="/checkout/view" />">
							Proceed to Checkout
						</a>
					</div>
				</div>

	
	</form>
