<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <script>
	<%@ include file = "/template/admin/plugins/jquery/jquery.min.js"%>
</script>
<!-- jQuery UI 1.11.4 -->
<script>
	<%@ include file = "/template/admin/plugins/jquery-ui/jquery-ui.min.js"%>
</script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->

<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script>
	<%@ include file = "/template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"%>
</script>
<!-- ChartJS -->
<script>
	<%@ include file = "/template/admin/plugins/chart.js/Chart.min.js"%>
</script>
<!-- Sparkline -->
<script>
	<%@ include file = "/template/admin/plugins/sparklines/sparkline.js"%>
</script>
<!-- JQVMap -->
<script>
	<%@ include file = "/template/admin/plugins/jqvmap/jquery.vmap.min.js"%>	
</script>
<script>
	<%@ include file = "/template/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"%>	
</script>
<!-- jQuery Knob Chart -->
<script src="<c:url value = '/template/admin/plugins/jquery-knob/jquery.knob.min.js'/>"></script>

<script >
	<%@ include file = "/template/admin/plugins/moment/moment.min.js"%>	
</script>
<script >
	<%@ include file = "/template/admin/plugins/daterangepicker/daterangepicker.js"%>	
</script>
<!-- Tempusdominus Bootstrap 4 -->
<script >
	<%@ include file = "/template/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"%>	
</script>
<!-- Summernote -->
<script>
	<%@ include file = "/template/admin/plugins/summernote/summernote-bs4.min.js"%>	
</script>
<!-- overlayScrollbars -->
<script>
	<%@ include file = "/template/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"%>	
</script>
<!-- AdminLTE App -->
<script>
	<%@ include file = "/template/admin/dist/js/adminlte.js"%>	
</script>
<!-- AdminLTE for demo purposes -->
<script>
	<%@ include file = "/template/admin/dist/js/demo.js"%>	
</script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script>
<%@ include file = "/template/admin/dist/js/pages/dashboard.js"%>	
</script>
