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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
  
<style>
	<%@ include file="/template/user/css/bootstrap.min.css" %>
	<%@ include file="/template/user/css/templatemo-style.css" %>
	<%@ include file="/template/user/fontawesome/css/all.min.css" %>
</style>
<body>
    <!-- Page Loader -->
	<%@include file="/common/user/header.jsp" %>
	
	
    <div class="container-fluid tm-container-content tm-mt-60">
       
       <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-12 tm-text-primary">${productDetails.title}</h2>
        </div>
        <div class="row tm-mb-90">            
            <div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
                    <img style="width: 950px; height: 500px; border-radius: 10px;" alt="" src="/ASM_Java4/${productDetails.poster}">
            </div>
            <div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
                <div class="tm-bg-gray tm-video-details">
                    <p class="mb-4">
                       ${productDetails.describe}
                    </p>
                    
                     <div class="mb-4 d-flex flex-wrap">
                        <div class="mr-4 mb-2">
                            <span class="tm-text-gray-dark">Quantity: </span><span class="tm-text-primary">${productDetails.quantity }</span>
                        </div>
                     </div>   
                     <div class="mb-4 d-flex flex-wrap">
                        <div class="mr-4 mb-2">
                            <span class="tm-text-gray-dark">Price: </span><span class="tm-text-primary">${productDetails.price }</span>
                        </div>
                     </div>        
                           
                    <div class="mb-4 d-flex flex-wrap">
                        <div class="mr-4 mb-2">
                            <span class="tm-text-gray-dark">View: </span><span class="tm-text-primary">${productDetails.view }</span>
                        </div>
                        <div class="mr-4 mb-2">
                            <span class="tm-text-gray-dark">Share: </span><span class="tm-text-primary">${productDetails.share}</span>
                        </div>
                        <div>
                            <span class="tm-text-gray-dark">Sold </span><span class="tm-text-primary">${productDetails.sold }</span>
                        </div>
                    </div>
                    <form action="/ASM_Java4/DetailsProductServlet/${productDetails.id}" method="post">
                     <div class="text-center mb-5">
                        <a href="/ASM_Java4/user/cart/${productDetails.id}" class="btn btn-primary tm-btn-big">Thêm Vào Giỏ Hàng</a>
                    </div>    
                   
                    <div class="text-center mb-5">
                    
                    	<button type="button"  class="btn btn-success" style="height: 35px; width: 100px; border-radius: 5px" data-bs-toggle="modal" data-bs-target="#exampleModal">
									 <i class="fas fa-share">
	                              	</i>	 
								 	Share
								</button>
							
							<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">Share Product</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        
						                <h5 >Recipient's email</h5>
						                <input type="email" id="emailRecipent" name="emailRecipent" class="form-control">
						              	<h5 >Conten</h5>
						                <input type="text" id="conten" name="conten" class="form-control">
						              
							      </div>
							      <div class="modal-footer">
							        <button type="submit" style="width: 100px; border-radius: 5px;" class="btn btn-secondary" data-bs-dismiss="modal">Share</button>
							      </div>
							    </div>
							  </div>
							</div>
						
                    </div>
                   </form>
                </div>
            </div>
        </div>
        <div class="row mb-4">
            <h2 class="col-12 tm-text-primary">
                Corresponding Products
            </h2>
        </div>
        <div class="row tm-mb-90 tm-gallery">
        <c:forEach var = "listProduct" items="${listProduct}" >
        	<div style="width: 370px; height: 250px;" class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <figure class="effect-ming tm-video-item">
                    <img style="width: 350px; height: 250px;"  src="/ASM_Java4/${listProduct.poster}" alt="Image" class="img-fluid">
                    <figcaption class="d-flex align-items-center justify-content-center">
                        <h2>Clocks</h2>
                        <a href="/ASM_Java4/DetailsProductServlet/${listProduct.id}">View more</a>
                    </figcaption>                    
                </figure>
                <div class="d-flex justify-content-between tm-text-gray">
                    <span class="tm-text-gray-light">${listProduct.title}</span>
                    <span>${listProduct.view} views</span>
                </div>
            </div>
         </c:forEach>
        </div>
    </div> <!-- container-fluid, tm-container-content -->
    </div> <!-- container-fluid, tm-container-content -->

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