<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="/common/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Admin | Product</title>

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
            <h1>Product</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              
              <li class="breadcrumb-item active">Product</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">${titleProduct}</h3>

          <div class="card-tools">
	          <form action="/admin/product" method="post">
	          	<button formaction="/ASM_Java4/admin/product/addProduct" type="submit" class="btn btn-primary">
	              Add
                </button>
	          </form>
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body p-0">
        
          <table class="table table-striped projects">
              <thead>
                  <tr>
                      <th style="width: 1%">
                          #
                      </th>
                      <th style="width: 5%">
                          Images
                      </th>
                      <th style="width: 15%">
                          Product Name
                      </th>
                      <th style="width: 10%">
                          Category
                      </th>
                      <th style="width: 5%">
                          Quantity
                      </th>
                      <th style="width: 5%">
                          Price
                      </th>
                      <th style="width: 5%">
                          View
                      </th>
                      <th style="width: 5%" >
                          Share
                      </th>
                      <th style="width: 5%">
                      	  Sold	
                      </th>
                      <th style="width: 15%">
                      	  Date Submitted
                      </th>
                      <th style="width: 10%">
                      	  Active	
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach var="product" items="${listProduct}">
	                  	<tr>
	                      <td>
	                          ${product.id}
	                      </td>
	                      
	                      <td>
	                          <ul class="list-inline">
	                              <li class="list-inline-item">
	                                  <img alt="Avatar" style="width: 50px; height: 50px; border-radius: 5px;" src="/ASM_Java4/${product.poster}">
	                              </li>
	                          </ul>
	                      </td>
	                      
	                      <td>
	                          <a>
	                              ${product.title}
	                          </a>
	                      </td>
	                      
	                      <td class="project_progress">
	                              <p>${product.category}</p>
	                      </td>
	                      
	                      <td>
	                      	<p>${product.quantity}</p>
	                      </td>
	                      <td>
	                      	<p>${product.price}</p>
	                      </td>
	                      <td>
	                      	<p>${product.view}</p>
	                      </td>
	                      <td>
	                      	<p>${product.share}</p>
	                      </td>
	                      <td>
	                      	<p>${product.sold}</p>
	                      </td>
	                      <td>
	                      	<p>${product.date_submitted	}</p>
	                      </td>
	                      <td class="project-state">
	                          <span class="badge badge-success">${product.isActive ? "Active" : "Not Active"}</span>
	                      </td>
	                      <td class="project-actions text-right">
	                      <form action="/ASM_Java4/admin/product/editProduct" method="post">
	                      	
	                      		<button formaction="/ASM_Java4/admin/product/edit/${product.id}" class="btn btn-primary"style="height: 35px; width: 100px;">
									<i class="fas fa-pencil-alt">
			                         </i>		  
									Edit
								</button>
								<button formaction="/ASM_Java4/admin/product/delete/${product.id}"  class="btn btn-danger" style="height: 35px; width: 100px;" data-bs-toggle="modal" data-bs-target="#exampleModal">
									 <i class="fas fa-trash">
	                              	</i>	 
								 	Delete
								</button>
							
							<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác Nhận Ẩn Sản Phẩm</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        ...
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <button formaction="/ASM_Java4/admin/product/delete/${product.id}" class="btn btn-primary">Delete Product</button>
							      </div>
							    </div>
							  </div>
							</div>
							</form>
									
	                      </td>
	                  </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
      </div>
    </section>
  </div>

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">Đinh Văn Hoàng - PH22844</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<%@ include file="/common/admin/script.jsp" %>
</body>
</html>
    