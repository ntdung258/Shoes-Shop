<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
      <!-- Main content -->
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
          
            <h2 class="margin-bottom-10">Update Product</h2>
            <span class="mtext-105 cl2 txt-center p-b-30" style="color:red">${error}</span>
            <form:form action="/ShoesShop/admin/update-product" class="templatemo-login-form" method="post" modelAttribute="product" enctype="multipart/form-data">
              <form:input type="hidden" class="form-control" 	path="id" value="${product.id }"/>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label>Name Product</label>
                     <form:input type="text" class="form-control" 	path="name" value="${product.name }"/> 
                    <form:errors path="name" style="color:red" />                 
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label>Code</label>
                     <form:input type="text" class="form-control" 	path="code" value="${product.code }"/> 
                    <form:errors path="code" style="color:red" />                  
                </div> 
              </div>
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label>Price</label>
                     <form:input type="number" class="form-control" path="price" value="${product.price }" /> 
                    <form:errors path="price" style="color:red" />                  
                </div>
                <div class="col-lg-6 col-md-6 form-group">                  
                    <label>Amount</label>
                     <form:input type="number" class="form-control" path="amount" value="${product.amount }" /> 
                    <form:errors path="amount" style="color:red" />                  
                </div> 
              </div>
              

              
              <div class="row form-group">
                <div class="col-lg-6 col-md-6 form-group"> 
                  <label class="control-label templatemo-block">Type Product</label>                 
                  <form:select class="form-control" path="type">
                  <c:forEach items="${listType }" var="type" >
                    <form:option value="${type.id }">${type.name }</form:option>
                  </c:forEach>                     
                  </form:select>
                </div>
               
                <div class="col-lg-6 col-md-6 form-group"> 
                  <label class="control-label templatemo-block">Color Product</label>                 
                  <form:select class="form-control" path="color_Product">
                    <c:forEach items="${listColor }" var="color" >
                    <form:option value="${color.id }">${color.name }</form:option>
                  </c:forEach>                     
                  </form:select>
                </div>
              </div>
              
             
              <div class="row form-group">
                <div class="col-lg-12">
                  <label class="control-label templatemo-block">Image</label> 
                  <input type="file" name="imageSource" class="filestyle" data-buttonName="btn-primary" data-buttonBefore="true" data-icon="false">
                  <p>Maximum upload size is 5 MB.</p>                  
                </div>
              </div>
              <div class="form-group text-right">
                <button type="submit" class="templatemo-blue-button">Update</button>
                <button type="reset" class="templatemo-white-button">Reset</button>
              </div>                           
            </form:form>
          </div>
          
        </div>
      </div>
    </div>