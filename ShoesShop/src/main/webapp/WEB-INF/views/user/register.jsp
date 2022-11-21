<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Register</title>
<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url(<c:url value="/assets/images/bg-01.jpg" />);">
		<h2 class="ltext-105 cl0 txt-center">
			Register
		</h2>
	</section>	


	<!-- Content page -->
	<section class="bg0 p-t-5 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">

				<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md m-auto">
					<form:form action="/ShoesShop/account/register" method="post" modelAttribute="userregister">
					
						<span class="mtext-105 cl2 txt-center p-b-30" style="color:red">${error}</span>
						<span class="mtext-105 cl2 txt-center p-b-30" style="color:#00FF00">${succsess}</span>
						
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="userName" style="color:red" />
							<form:input path="userName" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  placeholder="User name" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/userName.png" />" alt="ICON">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="password" style="color:red" />
							<form:input path="password" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="password"  placeholder="Password" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/password.png" />" alt="ICON">
						</div>
							
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="name" style="color:red" />
							<form:input path="name" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  placeholder="Full name" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/userName.png" />" alt="ICON">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="phone" style="color:red" />
							<form:input path="phone" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  placeholder="Phone number" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/phone.png" />" alt="ICON">
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="email" style="color:red" />
							<form:input path="email" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="email"  placeholder="Email" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/email.png" />" alt="ICON">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<form:errors path="address" style="color:red" />
							<form:input path="address" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text"  placeholder="Home Address" />
							<img class="how-pos4 pointer-none" src="<c:url value="/assets/images/icons/address.png" />" alt="ICON">
						</div>

						

						<button type="submit" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
							Register
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</section>	
