<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:forEach items="${products}" var="products">
	<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item">
		<!-- Block2 -->
		<div class="block2">
			<div class="block2-pic hov-img0">
				<img
					src="<c:url value="/assets/images/product/${products.linkImg}"></c:url>"
					alt="IMG-PRODUCT"> <a
					href="<c:url value="/shopping-cart/add/${products.id}"></c:url>"
					class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-addcart-detail ">
					Add to cart </a>

			</div>

			<div class="block2-txt flex-w flex-t p-t-14">
				<div class="block2-txt-child1 flex-col-l ">
					<a href="<c:url value="/product-detail/${products.id}"></c:url>"
						class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6 js-name-detail">
						${products.name} </a> <span class="stext-105 cl3"><fmt:formatNumber
							currencySymbol="" value="${products.price}"></fmt:formatNumber>
						(VND)</span>
				</div>

				<div class="block2-txt-child2 flex-r p-t-3">
					<a href="#"
						class="btn-addwish-b2 dis-block pos-relative js-addwish-b2"> <img
						class="icon-heart1 dis-block trans-04"
						src="<c:url value="/assets/images/icons/icon-heart-01.png"></c:url>"
						alt="ICON"> <img
						class="icon-heart2 dis-block trans-04 ab-t-l"
						src="<c:url value="/assets/images/icons/icon-heart-02.png"></c:url>"
						alt="ICON">
					</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
