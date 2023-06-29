<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H - Shop</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin='anonymous'></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel = "stylesheet" href="<c:url value = '/template/admin/plugins/fontawesome-free/css/all.min.css'/>">
</head>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	.menu-nav{
		height: 80px;	
		background: orange;
		width: 100%;
		background-size: 100% 100%;
		padding: 7px 150px;
	}
	
	.logo{
		height: 60px;
		width: 150px; 
	}
	h1{
		text-align: center;
	}
	
	.profile{
		height: 750px;
		width: 500px;
		background: #e0e0e0;
		margin: 30px 0 30px 0;
		padding: 30px 40px 0 40px;
		border-radius: 10px;
		border: 2px solid;
		box-shadow: 2px gray;
		margin-left: 400px;
	}
		.profile>form>img{
			margin: 30px 200px 30px 130px;
			text-align: center;
			height: 130px;
			width: 140px;
			border-radius: 50%;
			border: 1px solid;
		}
			.profile>form>div{
				display:flex;
			}
				.profile>form>div>h5{
					padding: 20px 15px 20px 10px;
				}
	.submit{
		padding-top: 90px;
		padding-left: 20px;
	}
		.submit>button{
			height: 40px;
			width: 160px;
			margin: 0 15px 0 15px;
			border-radius: 10px;
		}
	.site-footer{
	  background-color:#26272b;
	  padding:45px 0 20px;
	  font-size:15px;
	  line-height:24px;
	  color:#737373;
	}
	
	<%@ include file="/template/user/css/bootstrap.min.css" %>
	<%@ include file="/template/user/css/templatemo-style.css" %>
	<%@ include file="/template/user/fontawesome/css/all.min.css" %>
</style>
<body>
    <!-- Page Loader -->
	<%@include file="/common/user/header.jsp" %>
	
	<div class="container">
			<div class="profile">
				<h1>${title}</h1>
				<form action="${pageContext.request.contextPath}/index/profile/update/${sessionScope.currentUser.id}" method="post"  >
					<img alt="" src="/ASM_Java4/${sessionScope.currentUser.images}">
					<div>
						<h5>Họ Và Tên :</h5>
						<h5>${sessionScope.currentUser.fullname}</h5>
					</div>
					<div>
						<h5>Username :</h5>
						<h5>${sessionScope.currentUser.username}</h5>
					</div>
					<div>
						<h5>password :</h5>
						<h5>${sessionScope.currentUser.password}</h5>
					</div>
					<div>
						<h5>Email :</h5>
						<h5>${sessionScope.currentUser.email}</h5>
					</div>
				
					<div class="submit">
						<!-- Button Delete modal -->
						<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
						  Delete
						</button>
						
						<!-- Button Update modal -->
						<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
						  Update
						</button>
						
					
						<!-- Modal Update -->
					
						<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="staticBackdropLabel">Update Information</h1>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        <label>Fullname</label>
						        <input type="text" class="form-control" name="fullname" value="${sessionScope.currentUser.fullname}">
						      	<label>UserName</label>
						        <input type="text" class="form-control" name="username" aria-describedby="basic-addon1" value="${sessionScope.currentUser.username}">
						        <label>Password</label>
						        <input type="text" class="form-control" name="password" aria-describedby="basic-addon1" value="${sessionScope.currentUser.password}">
						        <label>Email</label>
						        <input type="text" class="form-control" name="email" aria-describedby="basic-addon1" value="${sessionScope.currentUser.email}">
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						        <button  type="submit" class="btn btn-success">Update</button>
						      </div>
						    </div>
						  </div>
						</div>
					 
					 
					 <!-- Modal Delete-->
						<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="exampleModalLabel">Delete Account</h1>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        Xác Nhận Xóa Tài Khoản
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						        <button formaction="${pageContext.request.contextPath}/index/profile/delete/${sessionScope.currentUser.id}" class="btn btn-danger">Delete Account</button>
						      </div>
						    </div>
						  </div>
						</div>
					</div>
				</form>
			</div>
		</div>
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