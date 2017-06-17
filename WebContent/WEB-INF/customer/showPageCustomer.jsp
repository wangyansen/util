<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<base href="<%=basePath%>">
<title>showshow</title>
<script  type="text/javascript" src="assets/jquery.min.js"></script>

<script type="text/javascript">
//动态时间JS
var nowTime=self.setInterval("time()", 200);
function time(){
	var currentTime = new Date();
	var dateString =currentTime.toLocaleString();
	$("#time").text(dateString);
};
</script>
<style type="text/css">
#time{
    position: absolute;
    top: 40px;
    margin-left: 100px;
    font-size: 50px;
}

</style>
</head>
<body class="background" >
<div>
<img  src="img/1112.png" style="background:rgba(0,0,0,0) center center no-repeat;width:100%;background-size:100% 100%;">
</div>
<div id="time"></div>
</body>
</html>