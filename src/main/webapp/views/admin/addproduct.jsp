<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/common/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Project Add</title>

  <%@ include file = "/common/admin/head.jsp"%>
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

<!-- Preloader And NAV -->
  <%@ include file="/common/admin/nav.jsp" %>
  <!-- Main Sidebar Container -->
  <%@ include file="/common/admin/aside.jsp" %>
  
    
   
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Product Add</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Product Add</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    

    <!-- Main content -->
    <form action="/ASM_Java4/admin/product" method="post" enctype="multipart/form-data">
    <section class="content"> 
    
      <div class="row">
        <div class="col-md-12 row">
          <div class="card card-primary row">
            <div class="card-header">
              <h3 class="card-title">General</h3>
              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            
            <div class="row">
            	<div class="card-body col-md-6">
	              <div class="form-group">
	                <label for="inputName">Product Name</label>
	                <input type="text" id="inputName" name = "productName" value="${listProdutById.title}" class="form-control">
	              </div>
	             
	              <div class="form-group">
	                <label for="inputStatus">Category</label>
	                <select  id="inputStatus" name="category" class="form-control custom-select">
	                  <option selected disabled>Select one</option>
	                  <option value="Đồ Gia Dụng" ${listProdutById.category == "Đồ Gia Dụng" ? "selected" : ""}>Đồ Gia Dụng</option>
	                  <option value="Trang Điểm"${listProdutById.category == "Trang Điểm" ? "selected" : ""}>Trang Điểm</option>
	                  <option  value="Giày"${listProdutById.category == "Trang Điểm" ? "selected" : ""}>Giày</option>
	                </select>
	              </div>
	              
	               <div class="form-group">
	                <label for="inputName">Price</label>
	                <input value="${listProdutById.price}" name="price" type="text" id="inputName" class="form-control">
	              </div>
	              
	              <div class="form-group">
	                <label for="inputName">Quantity</label>
	                <input value="${listProdutById.quantity}" name="quantity" type="text" id="inputName" class="form-control">
	              </div>
	              <div class="form-group">
	                <label for="inputName">Banner</label>
	                <input name = "photo" type="file" id="banner" class="form-control">
	              </div>
	            </div>
	            
	            <div class="card-body col-md-6">
	              <div class="form-group">
	                 <label for="inputDescription">Project Description</label>
	                 <textarea name="description" id="inputDescription" class="form-control" rows="4">${listProdutById.describe}</textarea>
	               </div>
	               
	               <div class="form-group">
	                <label >Active Product</label>
						<div class="row">
						<div class="col-md-2"></div>
							<div class="col-md-4">
								<input type="radio" name="active" value="true"  ${listProdutById.isActive == "true" ? "checked" : ""} id="flexRadioDefault2" checked="checked" >
								<label class="form-check-label" for="flexRadioDefault2">
								    Active
								</label>
							</div>
							<div class="col-md-4">
								<input type="radio" name="active"  value="false" ${listProdutById.isActive == "false" ? "checked" : ""} id="flexRadioDefault1" >
								<label class="form-check-label" for="flexRadioDefault1">
								    Not Active
								</label>
							</div>
						</div>
	               </div>
	               
	               <label for="inputDescription">Banner</label><br>
	               <img  style="width: 200px; height: 200px; border-radius: 5px;" id="banerDisplay" alt="" src="/ASM_Java4/${listProdutById.poster}">
	            </div>
            </div>
          <!-- /.card -->
        </div>
       </div>
      </div>
      <div class="row">
        <div class="col-12">
          <a href="#" class="btn btn-secondary">Cancel</a>
          <input type="submit" formaction="/ASM_Java4/admin/${submit}"  value="Create new Product" class="btn btn-success float-right">
        </div>
      </div>
    </section>
</form>
  </div>

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
    <strong>Copyright &copy; 2003-2023 <a href="">Đinh Văn Hoàng - PH22844</a>.</strong> All rights reserved.
  </footer>

</div>
<script type="text/javascript">
	const banner = document.getElementById("banerDisplay");
	input = document.getElementById("banner");
	show.addEventListener("change",() =>{
		banner.src = URL.createObjectURL(input.file[0]);
	});
</script>
<%@ include file="/common/admin/script.jsp" %>

</body>

</html>
    