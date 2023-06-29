<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="/common/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Projects</title>

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
            <h1>User</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">User</li>
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
          <h3 class="card-title">${message}</h3>
          <div class="card-tools">
	          <button type="button" class="btn btn-primary">
	              Add
            </button>
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
                      <th style="width: 20%">
                          FullName
                      </th>
                      <th style="width: 10%">
                          Images
                      </th>
                      <th>
                          UserName
                      </th>
                      <th style="width: 20%">
                          Email
                      </th>
                      <th style="width: 10%">
                          Permission
                      </th>
                      <th style="width: 8%" class="text-center">
                          Status
                      </th>
                      <th style="width: 20%">
                      </th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach var="user" items="${listUser}">
	                  	<tr>
	                      <td>
	                          ${user.id}
	                      </td>
	                      <td>
	                          <a>
	                              ${user.fullname}
	                          </a>
	                          <br/>
	                          <small>
	                              Created 01.01.2019
	                          </small>
	                      </td>
	                      <td>
	                          <ul class="list-inline">
	                              <li class="list-inline-item">
	                                  <img alt="Avatar" class="table-avatar" src="${user.images}">
	                              </li>
	                          </ul>
	                      </td>
	                      <td class="project_progress">
	                              <p>${user.username}</p>
	                      </td>
	                      <td>
	                      	<p>${user.email}</p>
	                      </td>
	                      <td class="project-state">
	                          <span class="badge badge-success">${user.isAdmin ? "Admin" : "User"}</span>
	                      </td>
	                      <td class="project-state">
	                          <span class="badge badge-success">${user.isActive ? "Active" : "Not Active"}</span>
	                      </td>
	                      <td class="project-actions text-right">
	                      
	                      <form action="/ASM_Java4/admin/user" method="post">
	                      	<button formaction="/ASM_Java4/admin/user/edit/${user.id}" class="btn btn-primary"style="height: 35px; width: 100px;">
								<i class="fas fa-pencil-alt">
		                         </i>		  
								Edit
							</button>
							<button formaction="/ASM_Java4/admin/user/delete/${user.id}" class="btn btn-danger" style="height: 35px; width: 100px;" data-bs-toggle="modal" data-bs-target="#exampleModal">
								<i class="fas fa-trash">
	                             </i>	 
								 Delete
							</button>
							
							
							</form>
	                      </td>
	                  </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
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
    