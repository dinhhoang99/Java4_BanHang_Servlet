<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/user/taglib.jsp" %>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H - Movie</title>
	
</head>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel = "stylesheet" href="<c:url value = '/template/admin/plugins/fontawesome-free/css/all.min.css'/>">
<style>
	<%@ include file="/template/user/css/bootstrap.min.css" %>
	<%@ include file="/template/user/css/templatemo-style.css" %>
	<%@ include file="/template/user/fontawesome/css/all.min.css" %>
</style>
<body>
    <!-- Page Loader -->
	<%@include file="/common/user/header.jsp" %>
	
	<form action="//ASM_Java4/DetailsProductServlet/" method="post">
    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Search Product
            </h2>
            
        </div>
        
        <div class="row tm-mb-90 tm-gallery">
        <c:forEach var = "listProduct" items="${listProduct}" >
        	<div style="width: 370px; height: 250px;" class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
                    <img style="width: 350px; height: 250px;"  src="/ASM_Java4/${listProduct.poster}" alt="Image" class="img-fluid">
                    <figcaption class="d-flex align-items-center justify-content-center">
                        <h2>Clocks</h2>
                        <a href="DetailsProductServlet/${listProduct.id}">View more</a>
                    </figcaption>                    
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                    <span class="tm-text-gray-light">${listProduct.title}</span>
                    <span>${listProduct.view} views</span>
                </div>
            </div>
           </c:forEach>
        </div> <!-- row -->
        
        
    </div> <!-- container-fluid, tm-container-content -->
</form>
	<%@ include file="/common/user/footer.jsp" %>
    
    <script >
    	<%@ include file = "/template/user/js/plugins.js"%>
    </script>
    <script>
        $(window).on("load", function() {
            $('body').addClass('loaded');
        });
    </script>
</body>
</html>