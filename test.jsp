<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%--<script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/data.js"></script>
    <script src="https://code.highcharts.com/modules/drilldown.js"></script>--%>
    <script src="highcharts/code/highcharts.js"></script>
    <script src="highcharts/code/modules/data.js"></script>
    <script src="highcharts/code/modules/drilldown.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    <body>
	<jsp:include page="./include/header.html" />
	<script>
	 // Create the chart
	 Highcharts.chart('container', {
	     chart: {
		 type: 'column'
	     },
	     title: {
		 text: '年度统计分析'
	     },
	     xAxis: {
		 type: 'category'
	     },
	     yAxis: {
		 title: {
		     text: '总额'
		 }

	     },
	     legend: {
		 enabled: false
	     },
	     plotOptions: {
		 series: {
		     borderWidth: 0,
		     dataLabels: {
			 enabled: true,
			 format: '{point.y:.1f}'
		     }
		 }
	     },

	     tooltip: {
		 headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
		 pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> of total<br/>'
	     },

	     series: [{
		 name: 'Brands',
		 colorByPoint: true,
		 data: <%=request.getAttribute("json")%>
	     }]
	     
	 });
	</script>
    </body>
</html>
