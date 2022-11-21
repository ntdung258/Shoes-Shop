<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
 
 <title>Checkout</title>  
<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url(<c:url value="/assets/images/bg-01.jpg" />);">
		<h2 class="ltext-105 cl0 txt-center">
			Delivery Information
		</h2>
	</section>	


	<!-- Content page -->
	<section class="bg0 p-t-5 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">

				<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md m-auto">
					<form:form action="/ShoesShop/checkout/createBill" method="post" modelAttribute="bill">
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="recipientName" style="color:red" />
							<form:input path="recipientName" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  value="${userInfo.name }" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/userName.png" />" alt="ICON">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="phone" style="color:red" />
							<form:input path="phone" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  value="${userInfo.phone }" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/phone.png" />" alt="ICON">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="deliAddress" style="color:red" />
							<form:input path="deliAddress" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  value="${userInfo.address }" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/address.png" />" alt="ICON">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="note" style="color:red" />
							<form:input path="note" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" placeholder="Note"  />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/address.png" />" alt="ICON">
						</div>

						

						<button type="submit" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
							ORDER
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</section>	