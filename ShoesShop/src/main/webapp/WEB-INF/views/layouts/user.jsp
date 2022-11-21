<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title><decorator:title default="Master-Layout" /></title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/assets/images/icons/favicon.png"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/bootstrap/css/bootstrap.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/fonts/iconic/css/material-design-iconic-font.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/fonts/linearicons-v1.0.0/icon-font.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/animate/animate.css"></c:url>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/css-hamburgers/hamburgers.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/animsition/css/animsition.min.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/select2/select2.min.css"></c:url>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/daterangepicker/daterangepicker.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/slick/slick.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/MagnificPopup/magnific-popup.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/vendor/perfect-scrollbar/perfect-scrollbar.css"></c:url>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/util.css"></c:url>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/main.css"></c:url>">
<!--===============================================================================================-->


</head>
<body class="animsition">
	
	<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
	
		<decorator:body></decorator:body>
	
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>



<!--===============================================================================================-->	
	<script src="<c:url value="/assets/vendor/jquery/jquery-3.2.1.min.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/animsition/js/animsition.min.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/bootstrap/js/popper.js"></c:url>"></script>
	<script src="<c:url value="/assets/vendor/bootstrap/js/bootstrap.min.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/select2/select2.min.js"></c:url>"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/daterangepicker/moment.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/vendor/daterangepicker/daterangepicker.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/slick/slick.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/js/slick-custom.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/parallax100/parallax100.js"></c:url>"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/MagnificPopup/jquery.magnific-popup.min.js"></c:url>"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		        	enabled:true
		        },
		        mainClass: 'mfp-fade'
		    });
		});
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/isotope/isotope.pkgd.min.js"></c:url>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/sweetalert/sweetalert.min.js"></c:url>"></script>
	<script>
	
	
		$('.js-addcart-detail').each(function(){
			var nameProduct = $(this).data("name");
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});
	
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></c:url>"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="<c:url value="/assets/js/main.js"></c:url>"></script>

	<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" />"></script>
	<script type="text/javascript">
	
		/* LoadMore */
		function LoadMore() {
			$.ajax({
			    type: "GET",
			    url: "/ShoesShop/ajax/load-more",
			    success: function(data){
			        var row = document.getElementById("product_load_more");
			        row.innerHTML += data;
			    }
			});
		}

		
		/* +- Shopping cart */
		
		$('.btn-num-product-down').on('click', function(){
	        var numProduct = Number($(this).next().val());
	        if(numProduct > 0) $(this).next().val(numProduct - 1);
	    });

	    $('.btn-num-product-up').on('click', function(){
	        var numProduct = Number($(this).prev().val());
	        $(this).prev().val(numProduct + 1);
	    });

		$('.changeAmount').click(function(){
			var id_Product = $(this).data("id");
			var amount = $("#edit-Amount-"+id_Product).val();
			if($(this).hasClass('btn-num-product-down')){	
					 $.ajax({
					    type: "GET",
					    url: "/ShoesShop/shopping-cart/update/"+id_Product+"/"+amount,
					    success: function(){
					    	location.reload();
					    }
					}); 		
			}else if($(this).hasClass('btn-num-product-up')){	
					 $.ajax({
					    type: "GET",
					    url: "/ShoesShop/shopping-cart/update/"+id_Product+"/"+amount,
					    success: function(){
					    	location.reload();
					    }
					});
			}
		});
		
		$('.num-product').change(function(){
			var id_Product = $(this).data("id");
			var amount = $("#edit-Amount-"+id_Product).val();
			$.ajax({
			    type: "GET",
			    url: "/ShoesShop/shopping-cart/update/"+id_Product+"/"+amount,
			    success: function(){
			    	location.reload();
			    }
			}); 		
		})
		
		
		$('.addToCart').click(function() {
			var id_Product = $(this).data("id");
			$.ajax({
			    type: "GET",
			    url: "/ShoesShop/shopping-cart/add/"+id_Product,
			    success: function(){
			    	location.reload();
			    }
			}); 
		});
		

		
	</script>
</body>
</html>