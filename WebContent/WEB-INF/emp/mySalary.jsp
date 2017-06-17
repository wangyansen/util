<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
 <base href="<%=basePath%>">
<meta charset="gbk">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="###">我的工资</a></li>
        <li>查看</li>
    </ul>
</div>
<form class="form-inline" action="###" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
         <label class="" for="activename" id="aa">我的发放工资记录</label>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>基本工资</th>
            <th>奖金</th>
            <th>工资发放时间</th>
        </tr>
        <c:forEach items="${list}" var="list" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ list.baseSalary} 元</td>
        	<td>${list.reward} 元</td>
        	<td><fmt:formatDate value="${ list.openTime}" pattern="yyyy-MM-dd" /></td>
        </tr>
        </c:forEach>
		
    </table>
</div>
</form>
</body>
</html>
