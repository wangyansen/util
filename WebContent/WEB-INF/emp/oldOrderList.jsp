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
    	<li><a href="stuStudent.do?findAllStudent">我的预约安排</a></li>
        <li>已处理过的预约记录</li>
    </ul>
</div>
<form class="form-inline" action="<%=basePath%>order/findOrderBySickerName.do?mark=2" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">预约人姓名：</label>
        <input type="text" class="form-control" id="activename" placeholder="请输入预约姓名" name="sickerName">
      </div>

    <input type="submit"  class="btn btn-danger"  value="查询"/>
</div>



<div class="row" style="padding:15px; padding-top:0px;">
	<table class="table  table-condensed table-striped">
		<tr>
        	<th>序号</th>
            <th>预约人姓名</th>
            <th>预约人性别</th>
            <th>预约人电话</th>
            <th>预约时间</th>
            <th>预约原因及备注</th>
            <th>预约状态</th>
        </tr>
         <c:forEach items="${orderList}" var="orderList" varStatus="idx">
        <tr>
        	<td>${idx.index+1}</td>
        	<td>${ orderList.user.userName}</td>
        	<td>${orderList.user.sex}</td>
        	<td>${ orderList.user.phone}</td>
        	<td><fmt:formatDate value="${ orderList.orderTime}" pattern="yyyy-MM-dd" /></td>
        	<td>${ orderList.remark}</td>
        	<td>已同意</td>
        </tr>
        </c:forEach>
		 
    </table>
</div>
</form>

</body>
</html>
