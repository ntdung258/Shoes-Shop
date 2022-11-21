<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<div class="profile-photo-container">
	<img src="<c:url value="/assets/admin/images/profile-photo.jpg" />"
		alt="Profile Photo" class="img-responsive">
	<div class="profile-photo-overlay"></div>
</div>
<form class="templatemo-search-form" role="search">
	<div class="input-group">
		<button type="submit" class="fa fa-search"></button>
		<input type="text" class="form-control" placeholder="Search"
			name="srch-term" id="srch-term">
	</div>
</form>